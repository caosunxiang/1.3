package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbShopFast;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-29
 */
public interface DbShopFastService extends IService<DbShopFast> {

	Body label(DbShopFast dbShopFast);//添加標籤

}
