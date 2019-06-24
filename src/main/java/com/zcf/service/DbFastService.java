package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbFast;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-29
 */
public interface DbFastService extends IService<DbFast> {

	Body getall();//查詢全部標籤
	
	Body add(String fName,String fCount);//增
	
	Body del(Integer fId);//删
	
	Body upd(Integer fId,String fName,String fCount);//改
	
	Body getone(Integer fId);//查

}
