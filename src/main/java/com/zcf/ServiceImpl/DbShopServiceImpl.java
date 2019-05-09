package com.zcf.ServiceImpl;

import com.zcf.pojo.DbFast;
import com.zcf.pojo.DbShop;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFastMapper;
import com.zcf.mapper.DbShopMapper;
import com.zcf.service.DbShopService;
import com.zcf.utils.IDUtils;
import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
public class DbShopServiceImpl extends ServiceImpl<DbShopMapper, DbShop> implements DbShopService {
	@Autowired
	private DbShopMapper dbShopMapper;
	@Autowired
	private DbFastMapper dbFastMapper;

	@Override
	public Body register(DbShop dbShop) {
		Integer ver=Integer.parseInt(IDUtils.Random());
		dbShop.setsVerify(ver);
		Integer count = dbShopMapper.insert(dbShop);
		if (count != 1) {
			return Body.newInstance(201, "注册失败");
		}
		return Body.newInstance(dbShop);
	}
	@Override
	public Body getshop(String sid) {
		EntityWrapper<DbShop> wrapper=new EntityWrapper<>();
		wrapper.eq("s_id", sid);
		DbShop dbShop=selectById(sid);
		if(dbShop!=null) {
			Integer hot=dbShop.getsHot();
			dbShopMapper.updateForSet("s_hot="+hot, wrapper);
			return Body.newInstance(dbShop);
		}
		return Body.newInstance(201, "没有符合条件的店铺");
	}
	@Override
	public Body userverify(Integer verify,String sid) {
		DbShop dbShop=dbShopMapper.selectById(sid);
		if(dbShop!=null) {
			if(verify==dbShop.getsVerify()) {
				return Body.newInstance(dbShop);
			}
			return Body.newInstance(201, "商家驗證失敗");
		}
		return Body.newInstance(201, "沒有符合要求的商家");
	}
	@Override
	public Body getbyhot(String sname) {
		EntityWrapper<DbShop>wrapper=new EntityWrapper<>();
		wrapper.orderBy("s_hot", false);
		if(!StringUtils.isEmpty(sname)) {
			wrapper.like("s_name", sname);
		}
		List<DbShop>list=dbShopMapper.selectList(wrapper);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}
	@Override
	public Body getbytime(String sname) {
		EntityWrapper<DbShop> wrapper=new EntityWrapper<>();
		wrapper.orderBy("s_time", false);
		if(!StringUtils.isEmpty(sname)) {
			wrapper.like("s_name", sname);
		}
		List<DbShop>list=dbShopMapper.selectList(wrapper);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}
	@Override
	public Body getbypark(String sname) {
		EntityWrapper<DbShop> wrapper=new EntityWrapper<>();
		wrapper.eq("s_park", 1);
		if(!StringUtils.isEmpty(sname)) {
			wrapper.like("s_name", sname);
		}
		List<DbShop> list=dbShopMapper.selectList(wrapper);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}
	@Override
	public Body getbyromance(String sname) {
		EntityWrapper<DbShop>wrapper=new EntityWrapper<>();
		wrapper.eq("s_romance", 1);
		if(!StringUtils.isEmpty(sname)) {
			wrapper.like("s_name", sname);
		}
		List<DbShop> list=dbShopMapper.selectList(wrapper);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}
	@Override
	public Body shop(List<Integer> fid,String name,BigDecimal ave1,BigDecimal ave2) {
		List<Map<String, Object>> list=dbShopMapper.shop(fid, name, ave1, ave2);
		for (Integer string : fid) {
			DbFast dbFast=dbFastMapper.selectById(string);
			Integer num =dbFast.getfCount();
			dbFast.setfCount(num+1);
			dbFastMapper.updateById(dbFast);
		}
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}
	@Override
	public Body  adlogin(String name,String pwd) {
		EntityWrapper< DbShop> wrapper=new EntityWrapper<>();
		wrapper.eq("s_name", name);
		wrapper.eq("s_verify", pwd);
		List<DbShop>list=dbShopMapper.selectList(wrapper);
		if(list.size()==0) {
			return Body.newInstance(201,"請先註冊");
		}
		return Body.newInstance(list.get(0));
	}
	@Override
	public Body forget(String phone,Integer pwd) {
		DbShop shop=dbShopMapper.phone(phone);
				if(shop==null) {
					return Body.newInstance(201, "手機號驗證有誤");
				}
				shop.setsVerify(pwd);
				Integer count=dbShopMapper.updateById(shop);
				if(count==1) {
					return Body.newInstance(shop);
				}
				return Body.newInstance(201, "修改失敗");
	}
<<<<<<< HEAD
	@Override
	public Body change(String sid,Integer verify1,Integer verify2) {
		DbShop dbShop=dbShopMapper.selectById(sid);
		if(dbShop!=null) {
			if(dbShop.getsVerify()!=verify1) {
				return Body.newInstance(201, "驗證碼不正確");
			}
			dbShop.setsVerify(verify2);
			Integer count=dbShopMapper.updateById(dbShop);
			if(count==1) {
				return Body.newInstance(dbShop);
			}
		}
		return Body.newInstance(201, "操作失敗");
	}
=======
>>>>>>> 90c2cac59635ed4e7576a34de1ea8482d3292f50
}
