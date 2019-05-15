package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbSet;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbSetService extends IService<DbSet> {

	Body getbyfid(String fid);

	Body getall();
	
	Body add(String setId,String setName,String setEnglishName,String setState,String setShop);

	Body del(String setId);
	
	Body upd(String setId,String setName,String setEnglishName,String setState,String setShop);
	
	
}
