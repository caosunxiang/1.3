package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbFoodService;

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
@RequestMapping("/dbFood")
@CrossOrigin
public class DbFoodController {
@Autowired
private DbFoodService dbFoodService;
/**
 * 查询菜品根据分类
 * @param sid
 * @param f_type
 * @return
 */
@PostMapping("/getfood")
public Body getfood(String sid,String f_type) {
	return dbFoodService.getfood(sid, f_type);
}
/**
 * 店鋪菜品按熱度排序
 * @param fid
 * @return
 */
@PostMapping("/fhot")
Body fhot(String sid) {
	if(StringUtils.isEmpty(sid)) {
		return Body.BODY_451;
	}
	return dbFoodService.fhot(sid);
}
/**
 * 查詢推薦菜品
 * @return
 */
@PostMapping("/recommend")
Body recommend() {
	return dbFoodService.recommend();
}
}

