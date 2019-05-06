package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zcf.common.json.Body;
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
}

