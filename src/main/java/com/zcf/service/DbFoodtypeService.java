package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbFoodtype;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbFoodtypeService extends IService<DbFoodtype> {

	Body getall(String sid);//查找商鋪分類

	Body add(DbFoodtype dbFoodtype);//添加分類

	Body de(Integer id);//刪除

	Body up(DbFoodtype dbFoodtype);//修改

	Body getone(Integer ftid);//唯一查询

}
