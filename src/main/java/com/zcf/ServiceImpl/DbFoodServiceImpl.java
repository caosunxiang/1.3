package com.zcf.ServiceImpl;

import com.zcf.pojo.DbActivity;
import com.zcf.pojo.DbFood;
import com.zcf.pojo.DbFoodtype;
import com.zcf.pojo.JsonTest;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFoodMapper;
import com.zcf.service.DbFoodService;
import com.zcf.service.DbFoodtypeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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
	@Autowired
	private DbFoodtypeService foodtypeService;
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
public Body getall() {
	List<DbActivity>list=dbFoodMapper.rand();
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "查询无果");
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
	public Body setrec(String sid,String fid) {
		EntityWrapper<DbFood>wrapper=new EntityWrapper<>();
		wrapper.eq("food_to_shop", sid);
		wrapper.eq("f_recommend", 1);
		Integer count=dbFoodMapper.selectCount(wrapper);
		if(count==5) {
			return Body.newInstance(201, "已經設置5個請講其他取消");
		}
		DbFood food=dbFoodMapper.selectById(fid);
		food.setfRecommend(1);
		Integer co=dbFoodMapper.updateById(food);
		if(co==1) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "修改錯誤");
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
	@Override
	public Body percentage(String sid) {
		List<Map<String, Object>>list=dbFoodMapper.percentage(sid);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "今日尚未出售");
		
	}
	@Override
	public Body updown(String fid,String state) {
		EntityWrapper<DbFood >wrapper=new EntityWrapper<>();
		wrapper.eq("f_id", fid);
		Integer count=dbFoodMapper.updateForSet("f_state='"+state+"'", wrapper);
		if(count==1) {
			return Body.newInstance();
		}
		return Body.newInstance(201, "操作失敗");
	}
	@Override
	public Body cancel(String fid) {
		EntityWrapper<DbFood>wrapper=new EntityWrapper<>();
		wrapper.eq("f_id", fid);
		Integer count=dbFoodMapper.updateForSet("f_recommend='0'", wrapper);
		if(count==1) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "修改失敗");
	}
	@Override
	public  Body getclassify(String sid) {
		EntityWrapper<DbFoodtype> wrapper=new EntityWrapper<>();
		if(!StringUtils.isEmpty(sid)) {
			wrapper.eq("foodtype_to_shop", sid);
		}
		List<DbFoodtype> list=foodtypeService.selectList(wrapper);
		EntityWrapper<DbFood> entityWrapper = new EntityWrapper<>();
		if (!StringUtils.isEmpty(sid)) {
			entityWrapper.eq("food_to_shop", sid);
		}
		List<DbFood> sfood = dbFoodMapper.selectList(entityWrapper);
		List<JsonTest<DbFood>>json=new ArrayList<>();
		for (DbFoodtype dbFoodtype : list) {
			List<DbFood> test=new ArrayList<>();
			JsonTest<DbFood> jsonTest=new JsonTest<DbFood>();
			for (DbFood dbFood : sfood) {
				if(Integer.parseInt(dbFood.getfType())==dbFoodtype.getFtId()) {
					jsonTest.setName(dbFoodtype.getFtName());
					test.add(dbFood);
				}else {
					continue;
				}
				jsonTest.setList(test);
			}
			json.add(jsonTest);
		}
		if (json.size()>0) {
			List<JsonTest<DbFood>>jsontest=new ArrayList<>();
			for (int i = 0; i < json.size(); i++) {
				if(json.get(i).getName()!=null) {
					jsontest.add(json.get(i));
				}
			}
			return Body.newInstance(jsontest);
		}
		return Body.newInstance(201, "查询无果");
	}
}
