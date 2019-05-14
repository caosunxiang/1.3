package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbOrder;

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
public interface DbOrderService extends IService<DbOrder> {

	Body addorder(DbOrder dbOrder,String fid,String msg,String price,String st);//添加訂單

	Body getone(String oid);//查询订单详情

	Body usedis(String oid, String did, String dtitle, BigDecimal dprice, BigDecimal res);//使用優惠券

	Body order(String oid, String ostate);//選擇支付方式支付

	Body over(String openid);//獲取已完成訂單條數

	Body getbyuid(String uid);//查詢個人訂單

	Body getbysid(String sid);//查詢商家訂單

	Body addtoorder(DbOrder dbOrder, String fid,String  message,String price,String st);//加單

	Body table(String sid);//查看餐廳每桌消費情況

	Body today();//計算當天總交易額和平均交易額

	Body finish(String oid);//查詢已完成訂單

	Body getover(String sid);//查詢店鋪完成的訂單

	Body bytable(String table, String sid);//按桌號查詢訂單詳情
	


}
