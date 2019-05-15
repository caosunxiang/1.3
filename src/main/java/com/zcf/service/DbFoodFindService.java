package com.zcf.service;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbFood;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.service.IService;
public interface DbFoodFindService extends IService<DbFood> {
	
	//添加
	Body  add(String fId,String fName,String fEnglishName,BigDecimal fPrice,String fState,String fPicture,String fType,String fTypeName,
			  String foodToShop,Integer fMonth,Integer fRecommend);
	
	//删除
	Body  del(String fId);
	
	//更新
	Body  upd(String fId,String fName,String fEnglishName,BigDecimal fPrice,String fState,String fPicture,String fType,String fTypeName,
			  String foodToShop,Integer fMonth,Integer fRecommend);
	
	//查询
	Body  get(String fType   ,String foodToShop);

}
