package com.zcf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbUserDiscounts;
import com.zcf.service.DbUserDiscountsService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/dbUserDiscounts")
@CrossOrigin
public class DbUserDiscountsController {
	@Autowired
	private DbUserDiscountsService dbUserDiscountsService;
	/**
	 * 領取優惠券
	 * @param uid
	 * @param did
	 * @return
	 */
	@PostMapping("/addud")
	Body addud(String uid,String did) {
		if(StringUtils.isEmpty(uid)||StringUtils.isEmpty(did)) {
			return Body.BODY_451;
		}
		DbUserDiscounts dbUserDiscounts=new DbUserDiscounts();
		dbUserDiscounts.setUdDiscountsid(did);
		dbUserDiscounts.setUdUserid(uid);
		return dbUserDiscountsService.addud(dbUserDiscounts);
	}

	/**
	 * 查詢優惠券個數
	 * @param openid
	 * @return
	 */
	@PostMapping("/discount")
	Body discount(String openid) {
		if(StringUtils.isEmpty(openid)) {
			return Body.BODY_451;
		}
		return dbUserDiscountsService.discount(openid);
	}
}

