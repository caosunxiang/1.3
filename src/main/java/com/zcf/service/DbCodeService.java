package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbCode;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-06-06
 */
public interface DbCodeService extends IService<DbCode> {

	Body addcode(String sid, Integer table);//生成二维码

	Body getall(String sid);//查询全部

	Body de(String sid);//删除

}
