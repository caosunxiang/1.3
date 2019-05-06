package com.zcf.ServiceImpl;

import com.zcf.pojo.DbActivity;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbActivityMapper;
import com.zcf.service.DbActivityService;
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
 * @since 2019-04-26
 */
@Service
public class DbActivityServiceImpl extends ServiceImpl<DbActivityMapper, DbActivity> implements DbActivityService {
@Autowired
private DbActivityMapper activityMapper;
@Override
public Body show() {
	EntityWrapper<DbActivity>wrapper=new EntityWrapper<>();
	wrapper.orderBy("a_id", false);
	List<DbActivity>list=activityMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "沒有更多活動信息");
}
@Override
public  Body addact(DbActivity activity) {
	Integer count=activityMapper.insert(activity);
	if(count==1) {
		return Body.newInstance(activity);
	}
	return Body.newInstance(201, "添加失敗");
}
@Override
public Body getbyaid(Integer aid) {
	Map<String , Object> map=activityMapper.getbyaid(aid);
	if(map.size()>0) {
		return Body.newInstance(map);
	}
	return Body.newInstance(201, "沒有此活動");
}
@Override
public Body getbysid(String sid) {
	EntityWrapper<DbActivity> wrapper=new EntityWrapper<>();
	wrapper.eq("activity_to_shop", sid);
	List<DbActivity>list=activityMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "查看商家優惠活動");
}
}
