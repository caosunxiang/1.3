package com.zcf.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.common.utils.Hutool;
import com.zcf.pojo.DbOutline;
import com.zcf.service.DbOutlineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-25
 */
@RestController
@RequestMapping("/dbOutline")
@CrossOrigin
public class DbOutlineController {
@Autowired
private DbOutlineService dbOutlineService;
/**
 * 查詢全部的大綱
 * @return
 */
@PostMapping("/getall")
Body getall() {
	return dbOutlineService.getall();
}

/**
 * 添加大綱
 * @param lcontent
 * @return
 */
@PostMapping("/add")
Body add(String lcontent) {
	if(StringUtils.isEmpty(lcontent)) {
		return Body.BODY_451;
	}
	DbOutline dbOutline=new DbOutline();
	dbOutline.setlId(Hutool.getId());
	dbOutline.setlContent(lcontent);
	return dbOutlineService.add(dbOutline);
}

/**
 * 修改大綱
 * @param lid
 * @param lcontent
 * @return
 */
@PostMapping("/up")
Body up(String lid, String lcontent,Integer lNum) {
	if(StringUtils.isEmpty(lid)||StringUtils.isEmpty(lcontent)||lNum==null) {
		return Body.BODY_451;
	}
	return dbOutlineService.up(lid, lcontent,lNum);
}

/**
 * 刪除大綱
 * @param lid
 * @return
 */
@PostMapping("/de")
Body de(String lid) {
	if(StringUtils.isEmpty(lid)) {
		return Body.BODY_451;
	}
	return dbOutlineService.de(lid);
}
/**
 * 大綱按次數排序
 * @param sid
 * @return 
 */
@PostMapping("/bysid")
Body bysid(String sid) {
	if (StringUtils.isEmpty(sid)) {
		return Body.BODY_451;
	}
	return dbOutlineService.bysid(sid);
}
/**
 * 唯一查詢
 * @param lid
 * @return
 */
@PostMapping("/getone")
Body getone(String lid) {
	if(StringUtils.isEmpty(lid)) {
		return Body.BODY_451;
	}
	return dbOutlineService.getone(lid);
}
}

