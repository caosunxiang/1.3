package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbUserShop;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbUserShopService extends IService<DbUserShop> {

	Body byopenid(String openid);//查看关注

	Body attention(DbUserShop dbUserShop);//關注店鋪

	Body cancel(Map<String, Object> columnMap);//氣消關注

}
