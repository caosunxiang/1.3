package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbUserShop;
import com.zcf.service.DbUserShopService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/dbUserShop")
@CrossOrigin
public class DbUserShopController {
@Autowired
private DbUserShopService userShopService;
/**
 * 查看关注
 * @param openid
 * @return
 */
@PostMapping("/byopenid")
Body byopenid(String openid) {
	if(StringUtils.isEmpty(openid)) {
		return Body.BODY_451;
	}
	return userShopService.byopenid(openid);
}
/**
 * 關注店鋪
 * @param uid
 * @param sid
 * @return
 */
@PostMapping("/attention")
Body attention(String uid,String sid) {
	if(StringUtils.isEmpty(sid)||StringUtils.isEmpty(uid)) {
		return Body.BODY_451;
	}
	DbUserShop dbUserShop=new DbUserShop();
	dbUserShop.setUsShopid(sid);
	dbUserShop.setUsUserid(uid);
		return userShopService.attention(dbUserShop);
}
/**
 * 氣消關注
 * @param sid
 * @param uid
 * @return
 */
@PostMapping("/cancel")
Body cancel(String sid,String uid) {
	if(StringUtils.isEmpty(sid)||StringUtils.isEmpty(uid)) {
		return Body.BODY_451;
	}
	Map<String, Object> columnMap=new HashMap<>();
	columnMap.put("us_userid", uid);
	columnMap.put("us_shopid", sid);
	return userShopService.cancel(columnMap);
}
}

