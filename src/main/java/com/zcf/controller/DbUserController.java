package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbUser;
import com.zcf.service.DbUserService;
import com.zcf.utils.CodetoOpenid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/dbUser")
@CrossOrigin
public class DbUserController {
@Autowired
private DbUserService dbUserService;
/**
 * 按距离排序
 * @param longitude
 * @param latitude
 * @param uid
 * @param sname
 * @return
 */
@PostMapping("/getbydistance")
Body getbydistance(String longitude, String latitude, String uid, String sname) {
	if(StringUtils.isEmpty(longitude)||StringUtils.isEmpty(latitude)||StringUtils.isEmpty(uid)) {
		return Body.BODY_451;
	}
	return dbUserService.getbydistance(longitude, latitude, uid, sname);
}
/**
 * 用戶註冊
 * @param uid
 * @param uname
 * @param uhead
 * @param uarea
 * @param pid
 * @return
 */
@PostMapping("/register")
public Body register(String uid,String uname,String uhead,String uarea,String pid) {
	if(StringUtils.isEmpty(uid)||StringUtils.isEmpty(uname)||StringUtils.isEmpty(uhead)||StringUtils.isEmpty(uarea)) {
		return Body.BODY_451;
	}
	uid=CodetoOpenid.getSessionByCode(uid);
	DbUser user=new DbUser();
	user.setOpenId(uid);
	user.setuArea(uarea);
	user.setParentId(pid);
	user.setuName(uname);
	user.setuHead(uhead);
	return dbUserService.register(user);
}
/**
 * 用戶登入
 * @param uid
 * @return
 */
@PostMapping("/login")
public Body login(String uid) {
	if(StringUtils.isEmpty(uid)) {
		return Body.BODY_451;
	}
	uid=CodetoOpenid.getSessionByCode(uid);
	return dbUserService.login(uid);
}
/**
 * 上传
 * @param files
 * @return
 */
@PostMapping("/head")
public Body  head(MultipartFile[] files) {
	if(files==null) {
		return Body.BODY_451;
	}
	return  dbUserService.head(files);
}
}

