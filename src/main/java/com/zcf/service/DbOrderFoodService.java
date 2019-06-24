package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbOrderFood;

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
public interface DbOrderFoodService extends IService<DbOrderFood> {

	Body add(String table, BigDecimal subtotal, String sid, String sname, String sename, String fid, String remark);

}
