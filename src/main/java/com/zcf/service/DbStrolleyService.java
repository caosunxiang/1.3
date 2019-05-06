package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbStrolley;
import com.zcf.utils.From;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbStrolleyService extends IService<DbStrolley> {

	Body addst(DbStrolley dbStrolley);//添加購物車

//	Body userst(String uid);

	Body userst(String uid, String sid);//查詢用戶在該商家的購物車

	Body dest(String stid);//刪除指定的購物車物品

	Body deall(List<String >  stid );//批量刪除購物車

}
