package com.zcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.service.DbAdminService;

@RestController
@RequestMapping("/dbAdmin")
@CrossOrigin
public class DbAdminController {
	@Autowired
	private DbAdminService dbAdminService;
	
	@PostMapping("/login")
	public Body login(String aId,String aPwd){
		if(StringUtils.isEmpty(aId)||StringUtils.isEmpty(aPwd)){
			return Body.BODY_400;
		}
		return dbAdminService.login(aId, aPwd);
	}
}
