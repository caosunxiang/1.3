package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbDiscounts;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbDiscountsService extends IService<DbDiscounts> {

	Body getbysid(String sid);

	Body getbyuid(String uid);

	Body sidtouid(String sid, String uid);

}
