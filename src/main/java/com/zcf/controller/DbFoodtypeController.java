package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbFoodtype;
import com.zcf.service.DbFoodtypeService;

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
/**
 * @param sid
 * @return
 */
@RestController
@RequestMapping("/dbFoodtype")
@CrossOrigin
public class DbFoodtypeController {
@Autowired
private DbFoodtypeService dbFoodtypeService;
/**
 * 查詢店鋪分類
 * @param sid
 * @return
 */
@PostMapping("/getall")
Body getall(String sid){
	return dbFoodtypeService.getall(sid);
} 

/**
 * 添加分類
 * @param name
 * @param sid
 * @return
 */
@PostMapping("/add")
Body add(String name ,String sid) {
	if(StringUtils.isEmpty(sid)||StringUtils.isEmpty(name)) {
		return Body.BODY_451;
	}
	DbFoodtype dbFoodtype=new DbFoodtype();
	dbFoodtype.setFoodtypeToShop(sid);
	dbFoodtype.setFtName(name);
	return dbFoodtypeService.add(dbFoodtype);
}
/**
 * 刪除
 * @param id
 * @return
 */
Body de(Integer id) {
	if (id==null) {
		return Body.BODY_451;
	}
	return dbFoodtypeService.de(id);
}

/**
 * 修改
 * @param name
 * @param sid
 * @param ftid
 * @return
 */
@PostMapping("/up")
Body up(String name ,String sid,Integer ftid) {
	if(StringUtils.isEmpty(sid)||StringUtils.isEmpty(name)||ftid==null) {
		return Body.BODY_451;
	}
	DbFoodtype dbFoodtype=new DbFoodtype();
	dbFoodtype.setFoodtypeToShop(sid);
	dbFoodtype.setFtId(ftid);
	dbFoodtype.setFtName(name);
	return dbFoodtypeService.up(dbFoodtype);
}
}

