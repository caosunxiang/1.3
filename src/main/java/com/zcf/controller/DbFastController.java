package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zcf.common.json.Body;
import com.zcf.service.DbFastService;

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
@RequestMapping("/dbFast")
@CrossOrigin
public class DbFastController {
@Autowired
private DbFastService dbFastService;

/**
 * 獲取全部標籤
 * @return
 */
@PostMapping("/getall")
Body getall() {
	return dbFastService.getall();
}
}

