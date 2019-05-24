package com.zcf.ServiceImpl;

import com.zcf.pojo.DbShop;
import com.zcf.pojo.DbUser;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbShopMapper;
import com.zcf.mapper.DbUserMapper;
import com.zcf.service.DbUserService;
import com.zcf.utils.AMapUtils;
import com.zcf.utils.LngLat;
import com.zcf.utils.UploadImgUtils;
import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@Service
public class DbUserServiceImpl extends ServiceImpl<DbUserMapper, DbUser> implements DbUserService {
	@Autowired
	private DbUserMapper dbUserMapper;
	@Autowired
	private DbShopMapper dbShopMapper;

	@Override
	public Body register(DbUser user) {
		DbUser dbUser = selectById(user.getOpenId());
		if (dbUser != null) {
			return Body.newInstance(201, "用户已存在");
		}
		Integer count = dbUserMapper.insert(user);
		if (count == 1) {
			return Body.newInstance(user);
		}
		return Body.newInstance(201, "注册失败");
	}

	@Override
	public Body login(String openid) {
		DbUser user = selectById(openid);	
		if (user != null) {
			return Body.newInstance(user);
		}
		return Body.newInstance(201, "登入失败，未授权。");
	}

	@Override
	public Body getbydistance(String longitude, String latitude, String uid,String sname) {
		EntityWrapper<DbUser> uwrapper = new EntityWrapper<>();
		uwrapper.eq("open_id", uid);
		EntityWrapper<DbShop> swrapper = new EntityWrapper<>();
		if(!StringUtils.isEmpty(sname)) {
			swrapper.like("s_name", sname);
		}
		dbUserMapper.updateForSet("u_longitude='" + longitude + "',u_latitude='" + latitude + "'", uwrapper);
		List<DbShop> list = dbShopMapper.selectList(swrapper);
		for (DbShop dbShop : list) {
			LngLat start = new LngLat(new Double(longitude), new Double(latitude));
			LngLat end = new LngLat(new Double(dbShop.getsLongitude()), new Double(dbShop.getsLatitude()));
			Double distance = AMapUtils.calculateLineDistance(start, end);
			dbShop.setDistance(distance);
		}
		   Collections.sort(list, new Comparator<DbShop>(){
	            /*
	             * int compare(Person p1, Person p2) 返回一个基本类型的整型，
	             * 返回负数表示：p1 小于p2，
	             * 返回0 表示：p1和p2相等，
	             * 返回正数表示：p1大于p2
	             */
	            public int compare(DbShop p1, DbShop p2) {
	                //按照Person的年龄进行升序排列
	                if(p1.getDistance() > p2.getDistance()){
	                    return 1;
	                }
	                if(p1.getDistance() == p2.getDistance()){
	                    return 0;
	                }
	                return -1;
	            }
	        });
		   if(list.size()>0) {
			   return Body.newInstance(list);
		   }
		   return Body.newInstance(201, "沒有符合條件的商鋪");
	}
@Override
	public Body  head(MultipartFile[] files) {
		try {
			String head = UploadImgUtils.uploadFiles(files);
			return Body.newInstance(head);
		} catch (Exception e) {
			e.printStackTrace();
		}
return Body.newInstance(201, "上传失败");
	}
}
