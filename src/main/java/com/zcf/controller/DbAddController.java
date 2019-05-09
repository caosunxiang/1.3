package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbAdd;
import com.zcf.service.DbAddService;

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
@RequestMapping("/dbAdd")
@CrossOrigin
public class DbAddController {
	@Autowired
	private DbAddService dbAddService;

	/**
	 * 根据菜品id查询加配信息
	 * 
	 * @param fid
	 * @return
	 */
	@PostMapping("/getbyfid")
	Body getbyfid(String fid) {
		if (StringUtils.isEmpty(fid)) {
			return Body.BODY_451;
		}
		return dbAddService.getbyfid(fid);
	}

	/**
	 * 查询所有的加配信息
	 * @return
	 */
	@PostMapping("/getall")
	Body getall() {
		return dbAddService.getall();
	}
	
<<<<<<< HEAD

	/**
	// 修改
	 * @param aid
	 * @param name
	 * @param ename
	 * @param price
	 * @param sid
	 * @return
	 */
	@PostMapping("/up")
	Body up(String aid, String name, String ename, BigDecimal price, String sid,String state) {
		if (StringUtils.isEmpty(aid) || StringUtils.isEmpty(ename) || StringUtils.isEmpty(name)
				|| StringUtils.isEmpty(sid)||StringUtils.isEmpty(state)) {
			return Body.BODY_451;

		}
		DbAdd add = new DbAdd();
		add.setAddEnglish(ename);
		add.setAddId(aid);
		add.setAddName(name);
		add.setAddPrice(price);
		add.setAddShop(sid);
		add.setAddState(state);
		return dbAddService.up(add);
	}
	/**
	// 刪除
	 * @param aid
	 * @return
	 */
	@PostMapping("/de")
	Body de(String aid) {
		if (StringUtils.isEmpty(aid)) {
			return Body.BODY_451;
		}
		return dbAddService.de(aid);
	}


	/**
	 * 	// 添加
	 * @param aid
	 * @param name
	 * @param ename
	 * @param price
	 * @param sid
	 * @param state
	 * @return
	 */
	@PostMapping("/add")
	Body add(String aid, String name, String ename, BigDecimal price, String sid,String state) {
		if(StringUtils.isEmpty(aid) || StringUtils.isEmpty(ename) || StringUtils.isEmpty(name)
				|| StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		DbAdd add = new DbAdd();
		add.setAddEnglish(ename);
		add.setAddId(aid);
		add.setAddName(name);
		add.setAddPrice(price);
		add.setAddShop(sid);
		return dbAddService.add(add);
	}
	}
=======
}
>>>>>>> 90c2cac59635ed4e7576a34de1ea8482d3292f50
