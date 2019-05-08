package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbCustom;
import com.zcf.service.DbCustomService;
import com.zcf.utils.IDUtils;

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
@RequestMapping("/dbCustom")
@CrossOrigin
public class DbCustomController {
	@Autowired
	private DbCustomService dbCustomService;

/**
 * 根据菜品查自定
 * @param fid
 * @return
 */
@PostMapping("/getbyfid")
Body getbyfid(String fid) {
	if(StringUtils.isEmpty(fid)) {
		return Body.BODY_451;
	}
	return dbCustomService.getbyfid(fid);
}

/**
 * 查询全部的自定菜单
 * @return
 */
@PostMapping("/getall")
Body getall() {
	return dbCustomService.getall();
}
/**
//添加
 * @param cid
 * @param name
 * @param ename
 * @param sid
 * @return
 */
@PostMapping("/add")
Body add(String cid,String name,String ename,String sid) {
	if(StringUtils.isEmpty(cid)||StringUtils.isEmpty(name)||StringUtils.isEmpty(sid)) {
		return Body.BODY_451;
	}
	DbCustom custom=new DbCustom();
	custom.setcEnglishName(ename);
	custom.setcId(IDUtils.genItemId()+"");
	custom.setcName(name);
	custom.setShopCustom(sid);
	return dbCustomService.add(custom);
}

/**
 * 删除
 * @param cid
 * @return
 */
@PostMapping("/de")
Body de(String cid) {
	if(StringUtils.isEmpty(cid)) {
		return Body.BODY_451;
	}
	return dbCustomService.de(cid);
}
/**
//修改
 * @param cid
 * @param name
 * @param ename
 * @param sid
 * @param state
 * @return
 */
@PostMapping("/up")
Body up(String cid,String name,String ename,String sid,String state) {
	if(StringUtils.isEmpty(cid)||StringUtils.isEmpty(name)||StringUtils.isEmpty(sid)||StringUtils.isEmpty(state)) {
		return Body.BODY_451;
	}
	DbCustom custom=new DbCustom();
	custom.setcEnglishName(ename);
	custom.setcId(IDUtils.genItemId()+"");
	custom.setcName(name);
	custom.setShopCustom(sid);
	custom.setcState(state);
	return dbCustomService.up(custom);
}

/**
 * 唯一查询
 * @param cid
 * @return
 */
@PostMapping("/getone")
Body getone(String cid) {
	if(StringUtils.isEmpty(cid)) {
		return Body.BODY_451;
	}
	return dbCustomService.getone(cid);
}
}
