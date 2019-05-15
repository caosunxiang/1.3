package com.zcf.service;

import com.baomidou.mybatisplus.service.IService;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbAdmin;

public interface DbAdminService  extends IService<DbAdmin>{
	
	
	Body login(String aId,String aPwd);

}
