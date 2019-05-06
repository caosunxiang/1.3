package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbDiscountsService;

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
@RequestMapping("/dbDiscounts")
@CrossOrigin
public class DbDiscountsController {
	@Autowired
	private DbDiscountsService dbDiscountsService;

	/**
	 * 查詢店鋪發佈的優惠券
	 * 
	 * @param sid
	 * @return
	 */
	@PostMapping("/getbysid")
	Body getbysid(String sid) {
		return dbDiscountsService.getbysid(sid);
	}

	/**
	 * 查詢用戶的優惠券
	 * 
	 * @param uid
	 * @return
	 */
	@PostMapping("/getbyuid")
	Body getbyuid(String uid) {
		if (StringUtils.isEmpty(uid)) {
			return Body.BODY_451;
		}
		return dbDiscountsService.getbyuid(uid);
	}

	/**
	 * 獲取用戶在該商家的優惠券
	 * 
	 * @param sid
	 * @param uid
	 * @return
	 */
	@PostMapping("/sidtouid")
	Body sidtouid(String sid, String uid) {
		if (StringUtils.isEmpty(uid) || StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbDiscountsService.sidtouid(sid, uid);
	}
}
