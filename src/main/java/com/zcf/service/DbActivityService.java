package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbActivity;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-26
 */
public interface DbActivityService extends IService<DbActivity> {

	Body show();//查詢活動

	Body addact(DbActivity activity);//添加活動

	Body getbyaid(Integer aid);//優惠活動唯一查詢

	Body getbysid(String sid);//查看商家優惠活動

}
