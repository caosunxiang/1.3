package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.common.utils.Hutool;
import com.zcf.pojo.DbStrolley;
import com.zcf.service.DbStrolleyService;
import com.zcf.utils.IDUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/dbStrolley")
@CrossOrigin
public class DbStrolleyController {
	@Autowired
	private DbStrolleyService strolleyService;

	/**
	 * 添加購物車
	 * 
	 * @param table
	 * @param sf
	 * @param sfname
	 * @param sfename
	 * @param price
	 * @param remark
	 * @param su
	 * @param ss
	 * @param ssname
	 * @param ssename
	 * @return
	 */
	@PostMapping("/addst")
	public Body addst(String table, String sf, String sfname, String sfename, BigDecimal price, String remark,
			String su, String ss, String ssname, String ssename) {
		if (StringUtils.isEmpty(table) || StringUtils.isEmpty(sf) || StringUtils.isEmpty(sfname)
				|| StringUtils.isEmpty(sfename) || StringUtils.isEmpty(su) || StringUtils.isEmpty(ss)
				|| StringUtils.isEmpty(ssname) || StringUtils.isEmpty(ssename) || price == null) {
			return Body.BODY_451;

		}
		DbStrolley dbStrolley = new DbStrolley();
		dbStrolley.setStrolleyFoodEname(sfename);
		dbStrolley.setStrolleyFoodName(sfname);
		dbStrolley.setStrolleyId(IDUtils.genItemId() + "");
		dbStrolley.setStrolleyNum(1);
		dbStrolley.setStrolleyPrice(price);
		dbStrolley.setStrolleyRemark(remark);
		dbStrolley.setStrolleyShopEname(ssename);
		dbStrolley.setStrolleyShopName(ssname);
		dbStrolley.setStrolleyTable(table);
		dbStrolley.setStrolleyTime(Hutool.parseDateToString());
		dbStrolley.setStrolleyToFood(sf);
		dbStrolley.setStrolleyToShop(ss);
		dbStrolley.setStrolleyTotal(price);
		dbStrolley.setStrolleyToUser(su);
		return strolleyService.addst(dbStrolley);

	}

	/**
	 * 用戶個人的購物車
	 * 
	 * @param uid
	 * @return
	 */
	@PostMapping("/userst")
	Body userst(String uid, String sid) {
		if (StringUtils.isEmpty(uid) || StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return strolleyService.userst(uid, sid);
	}
	/**
	 * 刪除選定的購物車信息
	 * @param stid
	 * @return
	 */
	@PostMapping("/dest")
	Body dest(String stid) {
		if(StringUtils.isEmpty(stid)) {
			return Body.BODY_451;
		}
		return strolleyService.dest(stid);
	}
	/**
	 * 批量刪除
	 * @param stid
	 * @return
	 */
	@PostMapping("/deall")
	Body deall(String stid) {
		if(StringUtils.isEmpty(stid)) {
			return Body.BODY_451;
		}
		List<String > list=new ArrayList<String>();
		stid=stid+",";
		 char a[]=stid.toCharArray();
		 Integer c=0;
			Integer changeCount =0;
		 for (int i = 0; i < a.length; i++) {
			 if(a[i]==',') {
				String string= stid.substring(c, i);
				c=i+1;
				System.out.println(string);
			 list.add(string);
			 changeCount++;
			 }
		 }
		return strolleyService.deall(list);
	}
}
