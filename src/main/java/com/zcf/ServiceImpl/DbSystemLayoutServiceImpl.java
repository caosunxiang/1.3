package com.zcf.ServiceImpl;

import com.zcf.pojo.DbSystemLayout;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbSystemLayoutMapper;
import com.zcf.service.DbSystemLayoutService;
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
 * @since 2019-05-16
 */
@Service
public class DbSystemLayoutServiceImpl extends ServiceImpl<DbSystemLayoutMapper, DbSystemLayout> implements DbSystemLayoutService {
@Autowired
private DbSystemLayoutMapper layoutMapper;
@Override
public Body one() {
	DbSystemLayout layout=layoutMapper.selectById(1);
	if(layout!=null) {
		return Body.newInstance(layout);
	}
	return Body.newInstance(201, "服務器內部錯誤");
}
@Override
public Body two() {
	DbSystemLayout layout=layoutMapper.selectById(2);
	if(layout!=null) {
		return Body.newInstance(layout);
	}
	return Body.newInstance(201, "服務器內部錯誤");
}
@Override
public Body three() {
	DbSystemLayout layout=layoutMapper.selectById(3);
	if(layout!=null) {
		return Body.newInstance(layout);
	}
	return Body.newInstance(201, "服務器內部錯誤");
}
@Override
public Body upone(String str,String id) {
	EntityWrapper<DbSystemLayout>wrapper=new EntityWrapper<>();
	wrapper.eq("slid", id);
	Integer count=layoutMapper.updateForSet("slcontent='"+str+"'", wrapper);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "服務器內部錯誤");
}
@Override
public Body uptwo(String str) {
	EntityWrapper<DbSystemLayout>wrapper=new EntityWrapper<>();
	wrapper.eq("slid", 2);
	Integer count=layoutMapper.updateForSet("slcontent='"+str+"'", wrapper);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "服務器內部錯誤");
}
@Override
public Body upthree(String str) {
	EntityWrapper<DbSystemLayout>wrapper=new EntityWrapper<>();
	wrapper.eq("slid", 3);
	Integer count=layoutMapper.updateForSet("slcontent='"+str+"'", wrapper);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "服務器內部錯誤");
}
@Override
public Body getall() {
	EntityWrapper<DbSystemLayout>wrapper=new EntityWrapper<>();
	List< DbSystemLayout>list=layoutMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "服務器內部錯誤");
}
@Override
public Body getone(Integer slid) {
	DbSystemLayout layout=layoutMapper.selectById(slid);
	if(layout!=null) {
		return Body.newInstance(layout);
	}
	return Body.newInstance(201, "失败");
}
}
