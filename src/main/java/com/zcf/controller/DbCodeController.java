package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-06-06
 */
@RestController
@RequestMapping("/dbCode")
@CrossOrigin
public class DbCodeController {
@Autowired
private DbCodeService codeService;

/**
 * 新增
 * @param sid
 * @param table
 * @return
 */
@PostMapping("/add")
Body addcode(String sid, Integer table) {
	if(StringUtils.isEmpty(sid)||table==null) {
		return Body.BODY_451;
	}
	return codeService.addcode(sid, table);
}

/**
 * 回去全部
 * @param sid
 * @return
 */
@PostMapping("/getall")
Body getall(String sid) {
	return codeService.getall(sid);
}
/**
 * 删除
 * @param sid
 * @return
 */
@PostMapping("/sid")
Body de(String sid) {
	if(StringUtils.isEmpty(sid)) {
		return Body.BODY_451;
	}
	return codeService.de(sid);
}
}

