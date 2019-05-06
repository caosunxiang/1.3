package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbActivity;
import com.zcf.service.DbActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-26
 */
@RestController
@RequestMapping("/dbActivity")
@CrossOrigin
public class DbActivityController {
	@Autowired
	private DbActivityService activityService;

	/**
	 * 查詢活動
	 * 
	 * @return
	 */
	@PostMapping("/show")
	Body show() {
		return activityService.show();
	}

	/**
	 * 添加活动
	 * @param atitle
	 * @param acon
	 * @param afcon
	 * @param head
	 * @param as
	 * @param ad
	 * @return
	 */
	@PostMapping("/addact")
	Body addact(String atitle, String acon, String afcon, String head, String as, String ad) {
		if (StringUtils.isEmpty(atitle) || StringUtils.isEmpty(acon) || StringUtils.isEmpty(afcon)
				||  StringUtils.isEmpty(as) || StringUtils.isEmpty(ad)) {
			return Body.BODY_451;
		}
		DbActivity activity=new DbActivity();
		activity.setaContent(acon);
		activity.setActivityToDiscounts(ad);
		activity.setActivityToShop(as);
		activity.setaFcontent(afcon);
		activity.setaHead(head);
		activity.setaTitle(atitle);
		return activityService.addact(activity);
	}
	/**
	 * 優惠詳情
	 * @param aid
	 * @return
	 */
	@PostMapping("/getbyaid")
	Body getbyaid(Integer aid) {
		if(aid==null) {
			return Body.BODY_451;
		}
		return activityService.getbyaid(aid);
	}
	/**
	 * 查看商家優惠活動
	 * @param sid
	 * @return
	 */
	@PostMapping("/getbysid")
	Body getbysid(String sid) {
		if (StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return activityService.getbysid(sid);
	}
}
