package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbUserDiscounts;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbUserDiscountsService extends IService<DbUserDiscounts> {

	Body addud(DbUserDiscounts dbUserDiscounts);//領取優惠券

	Body discount(String openid);//用戶已有的優惠券

}
