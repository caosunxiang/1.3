package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFastMapper;
import com.zcf.service.DbFastService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-29
 */
@RestController
@RequestMapping("/dbFast")
@CrossOrigin
public class DbFastController {
	@Autowired
	private DbFastService dbFastService;

	/**
	 * 獲取全部標籤
	 * 
	 * @return
	 */
	@PostMapping("/getall")
	Body getall() {
		return dbFastService.getall();
	}

	/**
	 * 添加快捷搜索
	 * @param fId
	 * @param fName
	 * @param fCount
	 * @return
	 */
	@PostMapping("/add")
	Body add(String fId, String fName, String fCount) {
		if (StringUtils.isEmpty(fId) || StringUtils.isEmpty(fName) || StringUtils.isEmpty(fCount)) {
			return Body.BODY_451;
		}
		return dbFastService.add(fId, fName, fCount);
	}

	/**
	 * 删除快捷搜索
	 * @param fId
	 * @return
	 */
	@PostMapping("/del")
	Body del(String fId) {
		if (StringUtils.isEmpty(fId)) {
			return Body.BODY_451;
		}
		return dbFastService.del(fId);

	}

	/**
	 * 修改快捷搜索
	 * @param fId
	 * @param fName
	 * @param fCount
	 * @return
	 */
	@PostMapping("/upd")
	Body upd(String fId, String fName, String fCount) {
		if (StringUtils.isEmpty(fId) || StringUtils.isEmpty(fName) || StringUtils.isEmpty(fCount)) {
			return Body.BODY_451;
		}
		return dbFastService.upd(fId, fName, fCount);
	}

	/**
	 * 唯一查询
	 * @param fId
	 * @return
	 */
	@PostMapping("/getone")
	Body get(String fId) {
		if (StringUtils.isEmpty(fId)) {
			return Body.BODY_400;
		}
		return dbFastService.getone(fId);

	}
}
