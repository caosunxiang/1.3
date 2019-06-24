package com.zcf.ServiceImpl;

import com.zcf.pojo.DbActivity;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbActivityMapper;
import com.zcf.service.DbActivityService;
import com.zcf.utils.AMapUtils;
import com.zcf.utils.LngLat;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

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
@Override
public Body de(Integer aid) {
	Integer count=activityMapper.deleteById(aid);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "失败");
}
@Override
public Body up(String aid,String did) {
	EntityWrapper<DbActivity>wrapper=new EntityWrapper<>();
	wrapper.eq("a_id", aid);
	Integer count=activityMapper.updateForSet("activity_to_discounts='"+did+"'", wrapper);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "修改失败");
}
@Override
public Body near(String longitude,String latitude) {
	List<Map<String, Object>>list=activityMapper.near();
	 if(list.size()>0) {
		 for (Map<String, Object> map : list) {
				LngLat start = new LngLat(new Double(longitude), new Double(latitude));
				LngLat end = new LngLat(Double.parseDouble((String)map.get("s_longitude")),Double.parseDouble((String) map.get("s_latitude")));
				Double distance = AMapUtils.calculateLineDistance(start, end);
				map.put("distance", distance);
			}
			 Collections.sort(list, new Comparator<Map<String , Object>>(){
		         /*
		          * int compare(Person p1, Person p2) 返回一个基本类型的整型，
		          * 返回负数表示：p1 小于p2，
		          * 返回0 表示：p1和p2相等，
		          * 返回正数表示：p1大于p2
		          */
		         public int compare(Map<String , Object> p1, Map<String , Object> p2) {
		             //按照Person的年龄进行升序排列
		             if((double)p1.get("distance") >(double)p2.get("distance")){
		                 return 1;
		             }
		             if((double)p1.get("distance") ==(double)p2.get("distance")){
		                 return 0;
		             }
		             return -1;
		         }
		     });
		 return Body.newInstance(list);
	 }
	 return Body.newInstance(201, "查询无果");
}
}
