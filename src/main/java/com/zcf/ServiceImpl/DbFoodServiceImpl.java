package com.zcf.ServiceImpl;

import com.zcf.pojo.DbFood;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFoodMapper;
import com.zcf.service.DbFoodService;
import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
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
	Integer count=dbFoodMapper.insert(dbFood);
	if(count==1) {
		return Body.newInstance(dbFood);
	}
	return Body.newInstance(201, "添加失败");
	
}
@Override
public Body getfood(String sid,String f_type) {
	EntityWrapper<DbFood>wrapper=new EntityWrapper<>();
	if(!StringUtils.isEmpty(sid)) {
		wrapper.eq("food_to_shop", sid);
	}
	if(!StringUtils.isEmpty(f_type)) {
		wrapper.eq("f_type", f_type);
	}
	List<DbFood> list=dbFoodMapper.selectList(wrapper);
	if(list.size()>0) {
         return Body.newInstance(list);
	}
	return Body.newInstance(201, "此分类无商品信息");
}
@Override
public Body fhot(String sid) {
	EntityWrapper<DbFood> wrapper=new EntityWrapper<>();
	wrapper.eq("food_to_shop", sid);
	wrapper.orderBy("f_month", false);
	List<DbFood> list=dbFoodMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "查詢無果");
}
@Override
public Body recommend(){
	EntityWrapper<DbFood>wrapper=new EntityWrapper<>();
	wrapper.eq("f_recommend", 1);
	List<DbFood> list=dbFoodMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "查詢無果");
}

}
