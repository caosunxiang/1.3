package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.common.utils.Hutool;
import com.zcf.pojo.DbOrder;
import com.zcf.service.DbOrderService;
import com.zcf.utils.IDUtils;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/dbOrder")
@CrossOrigin
public class DbOrderController {
	@Autowired
	private DbOrderService dbOrderService;

	/**
	 * 添加訂單
	 * 
	 * @param table
	 * @param subtotal
	 * @param total
	 * @param uid
	 * @param sid
	 * @param sname
	 * @param sename
	 * @param fid
	 * @return
	 */
	@PostMapping("/addorder")
	public Body addorder(String table, BigDecimal subtotal, String uid, String sid, String sname, String sename,
			String fid,String msg,String price,String st) {
		if (StringUtils.isEmpty(table) || StringUtils.isEmpty(uid) || StringUtils.isEmpty(sid)
				|| StringUtils.isEmpty(sname) || StringUtils.isEmpty(sename) || subtotal == null
				|| StringUtils.isEmpty(fid)||StringUtils.isEmpty(st)) {
			return Body.BODY_451;
		}
		DbOrder dbOrder = new DbOrder();
		dbOrder.setoId(IDUtils.genItemId() + "");
		dbOrder.setOrderToShop(sid);
		dbOrder.setOrderToUser(uid);
		dbOrder.setoServiceCharge(subtotal.multiply(new BigDecimal(0.1)));
		dbOrder.setoShopEname(sename);
		dbOrder.setoShopName(sname);
		dbOrder.setoStrolleyTable(table);
		dbOrder.setoSubtotal(subtotal);
		dbOrder.setoTime(Hutool.parseDateToString());
		dbOrder.setoTotal(dbOrder.getoServiceCharge().add(subtotal));
		return dbOrderService.addorder(dbOrder, fid,msg,price, st);
	}

	/**
	 * 查询订单详情
	 * 
	 * @param oid
	 * @return
	 */
	@PostMapping("/getone")
	Body getone(String oid) {
		if (StringUtils.isEmpty(oid)) {
			return Body.BODY_451;
		}
		return dbOrderService.getone(oid);
	}

	/**
	 * 使用優惠券
	 * 
	 * @param oid
	 * @param did
	 * @param dtitle
	 * @param dprice
	 * @param res
	 * @return
	 */
	@PostMapping("/usedis")
	Body usedis(String oid, String did, String dtitle, BigDecimal dprice, BigDecimal res) {
		if (StringUtils.isEmpty(oid) || StringUtils.isEmpty(did) || StringUtils.isEmpty(dtitle) || dprice == null) {
			return Body.BODY_451;

		}
		return dbOrderService.usedis(oid, did, dtitle, dprice, res);
	}

	/**
	 * 選擇付費方式進行付費
	 * 
	 * @param oid
	 * @param ostate
	 * @return
	 */
	@PostMapping("/order")
	Body order(String oid, String ostate) {
		if (StringUtils.isEmpty(oid) || StringUtils.isEmpty(ostate)) {
			return Body.BODY_451 ;
		}
		return dbOrderService.order(oid, ostate);
	}

	/**
	 * 已完成訂單數
	 * @param openid
	 * @return
	 */
	@PostMapping("/over")
	Body over(String sid) {
		if (StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbOrderService.over(sid);
	}
	/**
	 * 查詢個人訂單
	 * @param uid
	 * @return
	 */
	@PostMapping("/getbyuid")
	Body getbyuid(String uid) {
		if(StringUtils.isEmpty(uid)) {
			return Body.BODY_451;
		}
		return dbOrderService.getbyuid(uid);
	}
	/**
	 * 查看商鋪訂單
	 * @param sid
	 * @return
	 */
	@PostMapping("/getbysid")
	Body getbysid(String sid) {
		if(StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbOrderService.getbysid(sid);
	}
	
	/**
	 * 加單
	 * @param table
	 * @param subtotal
	 * @param uid
	 * @param sid
	 * @param sname
	 * @param sename
	 * @param fid
	 * @return
	 */
	@PostMapping("/toorder")
	public Body addtoorder(String oid,
			String fid,String  message,String price,String st) {
		if (StringUtils.isEmpty(oid)
				|| StringUtils.isEmpty(fid)) {
			return Body.BODY_451;
		}
		return dbOrderService.addtoorder(oid, fid,message,price,st);
	}

	/**
	//查看餐廳每桌消費情況
	 * @param sid
	 * @return
	 */
	@PostMapping("/table")
	Body table(String sid) {
		if (StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbOrderService.table(sid);
	}
	/**
	//計算當天總交易額和平均交易額
	 * @return
	 */
	@PostMapping("/today")
	Body today(String sid) {
		return dbOrderService.today(sid); 
	}
	/**
	 * //查詢已完成訂單詳情
	 * @param oid
	 * @return
	 */
	@PostMapping("/finish")
	Body finish(String oid) {
		if(StringUtils.isEmpty(oid)) {
			return Body.BODY_451;
		}
		return dbOrderService.finish(oid);
	}
	/**
	 * //查詢店鋪完成的訂單
	 * @param sid
	 * @return
	 */
	@PostMapping("/getover")
	Body getover(String sid) {
		if(StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbOrderService.getover(sid);
	}
	/**
	 * //按桌號查詢訂單詳情
	 * @param table
	 * @param sid
	 * @return
	 */
	@PostMapping("/bytable")
	Body bytable(String table, String sid) {
		if(StringUtils.isEmpty(table)||StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbOrderService.bytable(table, sid);
	}
	/**
	 * ;//查询七天前的订单
	 * @return
	 */
	@PostMapping("/sevenago")
	Body sevenago() {
		return dbOrderService.sevenago();
	}
	/**
	 * ;//查询七小时前的订单
	 * @return
	 */
	@PostMapping("/sevenhour")
	Body sevenhour() {
		return dbOrderService.sevenhour();
	}
	/**
	 * 查詢所有的訂單
	 * @param state
	 * @return
	 */
	@PostMapping("/getallover")
	Body getallover(String state) {
		return dbOrderService.getallover(state);
	}
	/**
	 * 查詢訂單詳情
	 * @param table
	 * @param sid
	 * @param oid
	 * @return
	 */
	@PostMapping("/byalltable")
	Body byalltable(String table, String sid, String oid) {
		if(StringUtils.isEmpty(table)||StringUtils.isEmpty(sid)||StringUtils.isEmpty(oid)) {
			return Body.BODY_451;
		}
		return dbOrderService.byalltable(table, sid, oid);
	}
	/**
	 * 每桌状态
	 * @param sid
	 * @param num
	 * @return
	 */
	@PostMapping("/stable")
	Body table(String sid, Integer num) {
		if (StringUtils.isEmpty(sid)||num==null) {
			return Body.BODY_451;
		}
		return dbOrderService.table(sid,num);
	}
	/**
	 * 删除商家id
	 * @param sid
	 * @return
	 */
	@PostMapping("/deover")
	Body deover(String sid) {
		if(StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbOrderService.deover(sid);
	}
}