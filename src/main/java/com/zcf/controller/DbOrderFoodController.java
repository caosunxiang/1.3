package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbOrderFoodService;

import java.math.BigDecimal;

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
@RequestMapping("/dbOrderFood")
@CrossOrigin
public class DbOrderFoodController {
@Autowired 
private DbOrderFoodService service;
/**
 * 餐厅点餐
 * @param table
 * @param subtotal
 * @param sid
 * @param sname
 * @param sename
 * @param fid
 * @param remark
 * @return
 */
@PostMapping("/add")
Body add(String table, BigDecimal subtotal, String sid, String sname, String sename, String fid, String remark) {
	if(StringUtils.isEmpty(table) || StringUtils.isEmpty(fid) || StringUtils.isEmpty(sid)
			|| StringUtils.isEmpty(sname) || StringUtils.isEmpty(sename) || subtotal == null) {
		return Body.BODY_451;
	}
	return service.add(table, subtotal, sid, sname, sename, fid, remark);
}
}

