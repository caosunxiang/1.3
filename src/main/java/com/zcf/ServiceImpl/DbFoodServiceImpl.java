package com.zcf.ServiceImpl;

import com.zcf.pojo.DbFood;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFoodMapper;
import com.zcf.service.DbFoodService;
import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@Service
public class DbFoodServiceImpl extends ServiceImpl<DbFoodMapper, DbFood> implements DbFoodService {
	@Autowired
	private DbFoodMapper dbFoodMapper;

	@Override
	public Body addfood(DbFood dbFood) {
		Integer count = dbFoodMapper.insert(dbFood);
		if (count == 1) {
			return Body.newInstance(dbFood);
		}
		return Body.newInstance(201, "添加失败");

	}

	@Override
	public Body getfood(String sid, String f_type) {
		EntityWrapper<DbFood> wrapper = new EntityWrapper<>();
		wrapper.eq("f_state	", "1");
		if (!StringUtils.isEmpty(sid)) {
			wrapper.eq("food_to_shop", sid);
		}
		if (!StringUtils.isEmpty(f_type)) {
			wrapper.eq("f_type", f_type);
		}
		List<DbFood> list = dbFoodMapper.selectList(wrapper);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "此分类无商品信息");
	}

	@Override
	public Body fhot(String sid) {
		EntityWrapper<DbFood> wrapper = new EntityWrapper<>();
		wrapper.eq("f_state	", "1");
		wrapper.eq("food_to_shop", sid);
		wrapper.orderBy("f_month", false);
		List<DbFood> list = dbFoodMapper.selectList(wrapper);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}

	@Override
	public Body recommend() {
		EntityWrapper<DbFood> wrapper = new EntityWrapper<>();
		wrapper.eq("f_recommend", 1);
		wrapper.eq("f_state	", "1");
		List<DbFood> list = dbFoodMapper.selectList(wrapper);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}

	@Override
	public Body upfood(String fid, String name, String ename, BigDecimal price) {
		EntityWrapper<DbFood> wrapper = new EntityWrapper<>();
		wrapper.eq("f_id", fid);
		Integer count = dbFoodMapper
				.updateForSet("f_name='" + name + "',f_english_name='" + ename + "',f_price=" + price, wrapper);
		if(count==1) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "修改失敗");
	}
	@Override
	public Body getone(String fid) {
		DbFood dbFood=dbFoodMapper.selectById(fid);
		if(dbFood!=null) {
			return Body.newInstance(dbFood);
		}
		return Body.newInstance(201, "查詢失敗");
	}
	@Override
	public Body de(String fid) {
		Integer count=dbFoodMapper.deleteById(fid);
		if(count==1) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "刪除失敗");
	}
}
