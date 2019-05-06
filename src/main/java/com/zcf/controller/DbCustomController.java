package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbCustomService;

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
@RequestMapping("/dbCustom")
@CrossOrigin
public class DbCustomController {
	@Autowired
	private DbCustomService dbCustomService;

/**
 * 根据菜品查自定
 * @param fid
 * @return
 */
@PostMapping("/getbyfid")
Body getbyfid(String fid) {
	if(StringUtils.isEmpty(fid)) {
		return Body.BODY_451;
	}
	return dbCustomService.getbyfid(fid);
}

/**
 * 查询全部的自定菜单
 * @return
 */
@PostMapping("/getall")
Body getall() {
	return dbCustomService.getall();
}
}
