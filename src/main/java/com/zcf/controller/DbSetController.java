package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbSetService;

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
@RequestMapping("/dbSet")
@CrossOrigin
public class DbSetController {
@Autowired
private DbSetService dbSetService;
/**
 * 根据菜品id获取配套信息
 * @param fid
 * @return
 */
@PostMapping("/getbyfid")
Body getbyfid(String fid) {
	if(StringUtils.isEmpty(fid)) {
		return Body.BODY_451;
	}
	return dbSetService.getbyfid(fid);
}

/**
 * 获取全部的配套信息
 * @return
 */
@PostMapping("/getall")
Body getall() {
	return dbSetService.getall();
}
}

