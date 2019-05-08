package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbFood;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbFoodService extends IService<DbFood> {

	Body addfood(DbFood dbFood);//添加菜品

	Body getfood(String sid, String f_type);//查询菜品根据分类

	Body fhot(String sid);//店鋪菜品按熱度排序

	Body recommend();//查詢推薦菜品

	Body upfood(String fid, String name, String ename, BigDecimal price);//修改菜品名稱

	Body getone(String fid);//唯一查询

	Body de(String fid);//刪除菜品


}
