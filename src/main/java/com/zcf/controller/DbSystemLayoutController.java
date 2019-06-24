package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zcf.common.json.Body;
import com.zcf.service.DbSystemLayoutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouzhuang
 * @since 2019-05-16
 */
@RestController
@RequestMapping("/dbSystemLayout")
@CrossOrigin
public class DbSystemLayoutController {
@Autowired
private DbSystemLayoutService layoutService;
/**
//查詢夥計頁面彈窗內容
 * @return
 */
@PostMapping("/one")
Body one() {
	return layoutService.one();
}
/**
//查詢搜索框以上的內容
 * @return
 */
@PostMapping("/two")
Body two() {
	return layoutService.two();
}
/**
//查詢搜索框以下的內容
 * @return
 */
@PostMapping("/three")
Body three() {
	return layoutService.three();
}
/**
//修改夥計頁面彈窗內容
 * @param str
 * @return
 */
@PostMapping("/upone")
Body upone(String str,String id) {
	return layoutService.upone(str,id);
}
/**
//修改搜索框以上的內容
 * @param str
 * @return
 */
@PostMapping("/uptwo")
Body uptwo(String str) {
	return layoutService.uptwo(str);
}
/**
//修改搜索框以下的內容
 * @param str
 * @return
 */
@PostMapping("/upthree")
Body upthree(String str) {
	return layoutService.upthree(str);
}
/**
//查詢全部系統配置信息
 * @return
 */
@PostMapping("/getall")

Body getall() {
	return layoutService.getall();
}
/**
 * 唯一查询
 * @param slid
 * @return
 */
@PostMapping("/getone")
Body getone(Integer slid) {
	if (slid==null) {
		return Body.BODY_451;
	}
	return layoutService.getone(slid);
}
}

