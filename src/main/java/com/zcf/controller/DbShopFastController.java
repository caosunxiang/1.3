package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbShopFast;
import com.zcf.service.DbShopFastService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-29
 */
@RestController
@RequestMapping("/dbShopFast")
@CrossOrigin
public class DbShopFastController {
@Autowired
private DbShopFastService dbShopFastService;
/**
 * 添加標籤
 * @param sid
 * @param fid
 * @return
 */
@PostMapping("/label")
Body label(String sid	,Integer fid) {
	if (StringUtils.isEmpty(sid)||fid==null) {
		return Body.BODY_451;
	}
	DbShopFast dbShopFast=new DbShopFast();
	dbShopFast.setSfFastid(fid);
	dbShopFast.setSfShopid(sid);
	return dbShopFastService.label(dbShopFast);
}

}

