package com.zcf.ServiceImpl;

import com.zcf.pojo.DbUserShop;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbUserShopMapper;
import com.zcf.service.DbUserShopService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

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
public class DbUserShopServiceImpl extends ServiceImpl<DbUserShopMapper, DbUserShop> implements DbUserShopService {
@Autowired
private DbUserShopMapper userShopMapper;
@Override
public Body byopenid(String openid) {
	EntityWrapper<DbUserShop> wrapper=new EntityWrapper<>();
	wrapper.eq("us_userid", openid);
	List<Map<String, Object>>list=userShopMapper.byopenid(openid);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "沒有更多");
}
@Override
public Body attention(DbUserShop dbUserShop) {
	DbUserShop shop=userShopMapper.selectById(dbUserShop);
	if(shop!=null) {
		return Body.newInstance(201, "您已經關注過了");
	}
	Integer count =userShopMapper.insert(dbUserShop);
	if(count==1) {
		return Body.newInstance(dbUserShop);
	}
	return Body.newInstance(201, "關注成功");
}
@Override
public Body cancel(Map<String, Object> columnMap) {
	Integer count=userShopMapper.deleteByMap(columnMap);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "取消關注失敗");
}
}
