package com.zcf.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zcf.common.json.Body;
import com.zcf.service.DbFoodFindService;

@Controller
@RequestMapping("/Food")
@CrossOrigin
@ResponseBody
public class DbFoodFindController {
	@Autowired
	private DbFoodFindService dbFoodFindService;
	
	@PostMapping("/add")
	 Body add(String fId, String fName, String fEnglishName, BigDecimal fPrice, String fState, String fPicture,
		String fType, String fTypeName, String foodToShop, Integer fMonth, Integer fRecommend){
		return dbFoodFindService.add(fId, fName, fEnglishName, fPrice, fState, fPicture, fType, fTypeName, foodToShop, fMonth, fRecommend);
	}
	
	@PostMapping("/del")
	Body del(String fId){
		return dbFoodFindService.del(fId);
		
	}
	@PostMapping("/upd")
	Body upd(String fId, String fName, String fEnglishName, BigDecimal fPrice, String fState, String fPicture,
		String fType, String fTypeName, String foodToShop, Integer fMonth, Integer fRecommend){
		return dbFoodFindService.upd(fId, fName, fEnglishName, fPrice, fState, fPicture, fType, fTypeName, foodToShop, fMonth, fRecommend);
	}
	
	@PostMapping("/get")
	Body get(String fType, String foodToShop){
		return dbFoodFindService.get(fType, foodToShop);
	}

}
