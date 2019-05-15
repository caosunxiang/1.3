package com.zcf.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbUserMapper;
import com.zcf.pojo.DbUser;
import com.zcf.service.DbUserLoginService;
@Service
public class DbUserLoginServiceImpl extends ServiceImpl<DbUserMapper, DbUser> implements DbUserLoginService {
@Autowired
private DbUserMapper userMapper;
	@Override
	public Body login(String openId,String uName) {
		
		
		DbUser dbUser=userMapper.selectById(openId);
		
		if (dbUser!=null&&uName.equals(dbUser.getuName())) {
			
			return Body.newInstance(dbUser);
		}
		return Body.BODY_400;
	}
		
	}


