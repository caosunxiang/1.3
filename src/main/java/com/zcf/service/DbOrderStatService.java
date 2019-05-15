package com.zcf.service;

import com.baomidou.mybatisplus.service.IService;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbOrder;

public interface DbOrderStatService  extends IService<DbOrder>{
	
	
	Body statisH(); //最近几个小时的统计
	
    Body statisD(); //最近几天的统计
}
