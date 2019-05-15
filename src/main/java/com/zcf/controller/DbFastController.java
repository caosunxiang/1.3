package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFastMapper;
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


@PostMapping("/add")
Body add(String fId,String fName,String fCount){
	return dbFastService.add(fId, fName, fCount);
}

@PostMapping("/del")
Body del(String fId){
	return dbFastService.del(fId);
	
}
@PostMapping("/upd")
Body upd(String fId,String fName,String fCount){
	return dbFastService.upd(fId, fName, fCount);
}

@PostMapping("/getone")
Body get(String fId){
	if(StringUtils.isEmpty(fId)){
			return Body.BODY_400;
	}
	return dbFastService.getone(fId);
	
}
}

