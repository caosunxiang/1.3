package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbFood;
import com.zcf.service.DbFoodService;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/dbFood")
@CrossOrigin
public class DbFoodController {
	@Autowired
	private DbFoodService dbFoodService;

	/**
	 * 查询菜品根据分类
	 * 
	 * @param sid
	 * @param f_type
	 * @return
	 */
	@PostMapping("/getfood")
	public Body getfood(String sid, String f_type) {
		return dbFoodService.getfood(sid, f_type);
	}

	/**
	 * 店鋪菜品按熱度排序
	 * 
	 * @param fid
	 * @return
	 */
	@PostMapping("/fhot")
	Body fhot(String sid) {
		if (StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbFoodService.fhot(sid);
	}

	/**
	 * 查詢推薦菜品
	 * 
	 * @return
	 */
	@PostMapping("/recommend")
	Body recommend() {
		return dbFoodService.recommend();
	}

	/**
	 * 添加食品
	 * @param fid
	 * @param name
	 * @param ename
	 * @param price
	 * @param pic
	 * @param ftype
	 * @param ftname
	 * @param sid
	 * @return
	 */
	@PostMapping("/addfood")
	public Body addfood(String fid, String name, String ename, BigDecimal price, String pic, String ftype,
			String ftname, String sid) {
		if (StringUtils.isEmpty(fid) || StringUtils.isEmpty(name) || StringUtils.isEmpty(ename) || StringUtils.isEmpty(pic)
				|| StringUtils.isEmpty(ftype) || StringUtils.isEmpty(ftname) || StringUtils.isEmpty(sid)) {
			return Body.BODY_451;

		}
		DbFood dbFood=new DbFood();
		dbFood.setfEnglishName(ename);
		dbFood.setfId(fid);
		dbFood.setfName(name);
		dbFood.setFoodToShop(sid);
		dbFood.setfPicture(pic);
		dbFood.setfPrice(price);
		dbFood.setfType(ftype);
		dbFood.setfTypeName(ftname);
		return dbFoodService.addfood(dbFood);

	}
	/**
	 * 修改菜品名称
	 * @param fid
	 * @param name
	 * @param ename
	 * @param price
	 * @return
	 */
	@PostMapping("/upfood")
	Body upfood(String fid, String name, String ename, BigDecimal price) {
		if (StringUtils.isEmpty(fid) || StringUtils.isEmpty(name) || StringUtils.isEmpty(ename) || price==null) {
			return Body.BODY_451;
		}
		return dbFoodService.upfood(fid, name, ename, price);
	}
	/**
	 * //唯一查询
	 * @param fid
	 * @return
	 */
	@PostMapping("/getone")
	Body getone(String fid) {
		if(StringUtils.isEmpty(fid)) {
			return Body.BODY_451;
		}
		return dbFoodService.getone(fid);
	}
	
	/**
	 * 刪除菜品
	 * @param fid
	 * @return
	 * 
<<<<<<< HEAD
	 */ 

	@PostMapping("/de")
	Body de(String fid) {
		if(StringUtils.isEmpty(fid)) {
			return Body.BODY_451;
		}
		return dbFoodService.de(fid);
	}
}
