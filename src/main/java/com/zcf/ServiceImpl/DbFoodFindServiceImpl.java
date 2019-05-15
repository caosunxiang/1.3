package com.zcf.ServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFoodMapper;
import com.zcf.pojo.DbFood;
import com.zcf.service.DbFoodFindService;
@Service
public class DbFoodFindServiceImpl extends ServiceImpl<DbFoodMapper, DbFood> implements DbFoodFindService{
@Autowired
private DbFoodMapper dbFoodMapper;
	
	
	@Override
	public Body add(String fId, String fName, String fEnglishName, BigDecimal fPrice, String fState, String fPicture,
			String fType, String fTypeName, String foodToShop, Integer fMonth, Integer fRecommend) {
		DbFood  dbFood=new DbFood();
		dbFood.setfId(fId);
		dbFood.setfName(fName);
		dbFood.setfEnglishName(fEnglishName);
		dbFood.setfPrice(fPrice);
		dbFood.setfState(fState);
		dbFood.setfPicture(fPicture);
		dbFood.setfType(fType);
		dbFood.setfTypeName(fTypeName);
		dbFood.setFoodToShop(foodToShop);
		dbFood.setfMonth(fMonth);
		dbFood.setfRecommend(fRecommend);
		dbFoodMapper.insert(dbFood);
		return Body.BODY_200;
	}

	@Override
	public Body del(String fId) {
		
		Integer count=dbFoodMapper.deleteById(fId);
		if(count==1){
			return Body.BODY_200;
		}
		
		return Body.BODY_400;
	}

	@Override
	public Body upd(String fId, String fName, String fEnglishName, BigDecimal fPrice, String fState, String fPicture,
			String fType, String fTypeName, String foodToShop, Integer fMonth, Integer fRecommend) {
		
		DbFood  dbFood=new DbFood();
		dbFood.setfId(fId);
		dbFood.setfName(fName);
		dbFood.setfEnglishName(fEnglishName);
		dbFood.setfPrice(fPrice);
		dbFood.setfState(fState);
		dbFood.setfPicture(fPicture);
		dbFood.setfType(fType);
		dbFood.setfTypeName(fTypeName);
		dbFood.setFoodToShop(foodToShop);
		dbFood.setfMonth(fMonth);
		dbFood.setfRecommend(fRecommend);
		
	dbFoodMapper.updateById(dbFood);
		
		return Body.BODY_200;
	}

	@Override
	public Body get(String fType, String foodToShop) {
		
		EntityWrapper<DbFood>wrapper=new EntityWrapper<>();
		if(!StringUtils.isEmpty(fType)){  
			wrapper.eq("f_type",fType );
		}
		if(!StringUtils.isEmpty(foodToShop)){
			wrapper.eq("food_to_shop", foodToShop);
		}
		List<DbFood>list=dbFoodMapper.selectList(wrapper);
		
		if(list.size()>0){
			return Body.newInstance(list);
		}
		return Body.BODY_400;
	}




}
