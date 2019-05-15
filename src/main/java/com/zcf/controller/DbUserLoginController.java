package com.zcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbUserLoginService;

@RestController
@RequestMapping("/Test")
@CrossOrigin
public class DbUserLoginController {
	@Autowired
	private DbUserLoginService dbUserLoginService;
	
	@PostMapping("/login")
	public Body login(String openId,String uName){
		if(StringUtils.isEmpty(openId)||StringUtils.isEmpty(uName)){
			return Body.BODY_400;
		}
		return dbUserLoginService.login(openId,uName);
	}
}
