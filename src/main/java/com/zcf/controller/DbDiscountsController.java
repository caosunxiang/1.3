package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.pojo.DbDiscounts;
import com.zcf.service.DbDiscountsService;
import com.zcf.utils.IDUtils;

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
@RequestMapping("/dbDiscounts")
@CrossOrigin
public class DbDiscountsController {
	@Autowired
	private DbDiscountsService dbDiscountsService;

	/**
	 * 查詢店鋪發佈的優惠券
	 * 
	 * @param sid
	 * @return
	 */
	@PostMapping("/getbysid")
	public	Body getbysid(String sid) {
		return dbDiscountsService.getbysid(sid);
	}

	/**
	 * 查詢用戶的優惠券
	 * 
	 * @param uid
	 * @return
	 */
	@PostMapping("/getbyuid")
	public	Body getbyuid(String uid) {
		if (StringUtils.isEmpty(uid)) {
			return Body.BODY_451;
		}
		return dbDiscountsService.getbyuid(uid);
	}

	/**
	 * 獲取用戶在該商家的優惠券
	 * 
	 * @param sid
	 * @param uid
	 * @return
	 */
	@PostMapping("/sidtouid")
	public	Body sidtouid(String sid, String uid) {
		if (StringUtils.isEmpty(uid) || StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbDiscountsService.sidtouid(sid, uid);
	}

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	@PostMapping("/getall")
	public	Body getall() {
		return dbDiscountsService.getall();
	}

	/**
	 * 删除
	 * 
	 * @param did
	 * @return
	 */
	@PostMapping("/de")
	public	Body de(String did) {
		if (StringUtils.isEmpty(did)) {
			return Body.BODY_451;
		}
		return dbDiscountsService.de(did);
	}

	/**
	 * 添加优惠券
	 * @param dPrice
	 * @param dTitle
	 * @param dRemark
	 * @param dStarttime
	 * @param dOvertime
	 * @param dRestrict
	 * @param dMaximum
	 * @param discountsToShop
	 * @param dsName
	 * @param dsEname
	 * @return
	 */
	@PostMapping("/adddis")
	public	Body adddis(BigDecimal dPrice, String dTitle, String dRemark, String dStarttime, String dOvertime,
			BigDecimal dRestrict, Integer dMaximum, String discountsToShop, String dsName, String dsEname) {
		if (StringUtils.isEmpty(dTitle) || StringUtils.isEmpty(dRemark) || StringUtils.isEmpty(dStarttime)
				|| StringUtils.isEmpty(dOvertime) || StringUtils.isEmpty(discountsToShop) || StringUtils.isEmpty(dsName)
				|| StringUtils.isEmpty(dsEname) || dPrice==null||dRestrict==null||dMaximum==null) {
                   return Body.BODY_451;
		}
		DbDiscounts dbDiscounts=new DbDiscounts();
		dbDiscounts.setdId(IDUtils.genItemId()+"");
		dbDiscounts.setDiscountsToShop(discountsToShop);
		dbDiscounts.setdMaximum(dMaximum);
		dbDiscounts.setdOvertime(dOvertime);
		dbDiscounts.setdPrice(dPrice);
		dbDiscounts.setdRemark(dRemark);
		dbDiscounts.setdRestrict(dRestrict);
		dbDiscounts.setDsEname(dsEname);
		dbDiscounts.setDsName(dsName);
		dbDiscounts.setdStarttime(dStarttime);
		dbDiscounts.setdTitle(dTitle);
		return dbDiscountsService.adddis(dbDiscounts);
	}
	/**
	 * 唯一查詢
	 * @param did
	 * @return
	 */
	@PostMapping("/getone")
	public Body getone(String did) {
		if(StringUtils.isEmpty(did)) {
			return Body.BODY_451;
		}
		return dbDiscountsService.getone(did);
	}
}
