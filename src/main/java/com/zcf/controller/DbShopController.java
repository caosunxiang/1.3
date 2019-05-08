package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.common.utils.Hutool;
import com.zcf.pojo.DbShop;
import com.zcf.service.DbShopService;
import com.zcf.utils.IDUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/dbShop")
@CrossOrigin
public class DbShopController {
	@Autowired
	private DbShopService dbShopService;

	/**
	 * 根据商铺id
	 * 
	 * @param sid
	 * @return
	 */
	@PostMapping("/getshop")
	public Body getshop(String sid) {
		if (StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return dbShopService.getshop(sid);
	}

	/**
	 * 验证商家识别码
	 * 
	 * @param verify
	 * @param sid
	 * @return
	 */
	@PostMapping("/userverify")
	Body userverify(Integer verify, String sid) {
		if (StringUtils.isEmpty(sid) || verify == null) {
			return Body.BODY_451;
		}
		return dbShopService.userverify(verify, sid);
	}

	/**
	 * 按熱度排序
	 * 
	 * @return
	 */
	@PostMapping("/getbyhot")
	Body getbyhot(String sname) {
		return dbShopService.getbyhot(sname);
	}

	/**
	 * 按時間排序
	 * 
	 * @return
	 */
	@PostMapping("/getbytime")
	Body getbytime(String sname) {
		return dbShopService.getbytime(sname);
	}

	/**
	 * 是否可以停車
	 * 
	 * @return
	 */
	@PostMapping("/getbyparkf")
	Body getbypark(String sname) {
		return dbShopService.getbypark(sname);
	}

	/**
	 * 是否浪漫
	 * 
	 * @return
	 */
	@PostMapping("/getbyromance")
	Body getbyromance(String sname) {
		return dbShopService.getbyromance(sname);
	}

	/**
	 * 商铺注册
	 * 
	 * @param name
	 * @param ename
	 * @param btype
	 * @param type
	 * @param tname
	 * @param picture
	 * @param phone
	 * @param open
	 * @param colse
	 * @param longitude
	 * @param latitude
	 * @param ave
	 * @param area
	 * @param email
	 * @param remark
	 * @return
	 */
	@PostMapping("/register")
	public Body register(String name, String ename, String btype, String type, String tname, String picture,
			String phone, String open, String colse, String longitude, String latitude, BigDecimal ave, String area,
			String email, String remark) {
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(ename) || StringUtils.isEmpty(btype)
				|| StringUtils.isEmpty(type) || StringUtils.isEmpty(tname) || StringUtils.isEmpty(picture)
				|| StringUtils.isEmpty(phone) || StringUtils.isEmpty(open) || StringUtils.isEmpty(colse)
				|| StringUtils.isEmpty(area) || StringUtils.isEmpty(email) || StringUtils.isEmpty(remark)) {
			return Body.BODY_451;
		}
		DbShop dbShop = new DbShop();
		dbShop.setsArea(area);
		dbShop.setsAverage(ave);
		dbShop.setsBusinessType(btype);
		dbShop.setsCloseTime(colse);
		dbShop.setsEmail(email);
		dbShop.setsEnglishName(ename);
		dbShop.setsId(Hutool.getId());
		dbShop.setsLatitude(latitude);
		dbShop.setsLongitude(longitude);
		dbShop.setsName(name);
		dbShop.setsOpenTime(open);
		dbShop.setsPhone(phone);
		dbShop.setsPicture(picture);
		dbShop.setsRemark(remark);
		dbShop.setsTime(Hutool.parseDateToString());
		return dbShopService.register(dbShop);
	}

	/**
	 * 查詢商鋪
	 * @param fid
	 * @param name
	 * @param ave1
	 * @param ave2
	 * @return
	 */
	@PostMapping("/shop")
	Body shop(String  fid, String name, BigDecimal ave1, BigDecimal ave2) {
		if (StringUtils.isEmpty(fid)|| StringUtils.isEmpty(name) || ave1 == null || ave2 == null) {
			return Body.BODY_451;
		}
		List<Integer > list=new ArrayList<Integer>();
		fid=fid+",";
		 char a[]=fid.toCharArray();
		 Integer c=0;
			Integer changeCount =0;
		 for (int i = 0; i < a.length; i++) {
			 if(a[i]==',') {
				String string= fid.substring(c, i);
				c=i+1;
				Integer num= Integer.parseInt(string);
				System.out.println(string);
			 list.add(num);
			 changeCount++;
			 }
		 }
		return dbShopService.shop(list, name, ave1, ave2);
	}
	
	/**
	 * 後台登入
	 * @param name
	 * @param pwd
	 * @return
	 */
	@PostMapping("/adlogin")
	Body adlogin(String name, String pwd) {
		if(StringUtils.isEmpty(name)||StringUtils.isEmpty(pwd)) {
			return Body.BODY_451;
		}
		return dbShopService.adlogin(name, pwd);
	}
	/**
	 * 忘記密碼
	 * @param phone
	 * @param pwd
	 * @return
	 */
	@PostMapping("/forget")
	Body forget(String phone, Integer pwd) {
		if(StringUtils.isEmpty(phone)||pwd!=null) {
			return Body.BODY_451;
		}
		return dbShopService.forget(phone, pwd);
	}
	
}
