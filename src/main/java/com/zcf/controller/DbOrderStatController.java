package com.zcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zcf.common.json.Body;
import com.zcf.service.DbOrderStatService;

@RestController
@RequestMapping("/Dbst")
@CrossOrigin
public class DbOrderStatController  {
	
	@Autowired
	private  DbOrderStatService dbOrderStatService;
	
	@PostMapping("/hou")
	public  Body  DbOrderStatHou(){
		return dbOrderStatService.statisH();	
	}
	
	@PostMapping("/day")
	public Body  DbOrderStatDay(){
		return dbOrderStatService.statisD();
	}
}
