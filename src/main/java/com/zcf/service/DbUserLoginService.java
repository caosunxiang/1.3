package com.zcf.service;

import com.baomidou.mybatisplus.service.IService;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbUser;

public interface DbUserLoginService extends IService<DbUser>{
	
	
	Body login(String openId,String uName );
	

}
