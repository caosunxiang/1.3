package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbUserService extends IService<DbUser> {

	Body register(DbUser user);

	Body login(String openid);

	Body getbydistance(String longitude, String latitude, String uid, String sname);

}
