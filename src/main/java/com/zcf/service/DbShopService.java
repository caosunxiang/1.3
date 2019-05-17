package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbShop;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbShopService extends IService<DbShop> {

	Body getshop(String sid);//店铺唯一查询

	Body userverify(Integer verify, String sid);//用戶驗證商家識別碼

	Body getbyhot(String sname);//查詢按熱度查詢

	Body register(DbShop dbShop);//商铺注册

	Body getbytime(String sname);//按時間排序

	Body getbypark(String sname);//可否停車排序

	Body getbyromance(String sname);//是否浪漫

	Body shop(List<Integer> fid, String name, BigDecimal ave1, BigDecimal ave2);//條件查詢

	Body adlogin(String name, String pwd);//後台登入

	Body forget(String phone, Integer pwd);//忘記密碼


	Body change(String sid, Integer verify1, Integer verify2);//修改驗證碼

	Body change(DbShop shop);//修改商鋪


}
