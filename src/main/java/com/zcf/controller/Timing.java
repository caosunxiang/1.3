package com.zcf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zcf.common.utils.Hutool;
import com.zcf.mapper.DbActivityMapper;
import com.zcf.mapper.DbDiscountsMapper;
import com.zcf.mapper.DbFoodMapper;
import com.zcf.mapper.DbUserDiscountsMapper;
import com.zcf.pojo.DbActivity;
import com.zcf.pojo.DbDiscounts;
import com.zcf.pojo.DbFood;
import com.zcf.pojo.DbUserDiscounts;
/**
 * 所有定时任务
 * */
@EnableScheduling
@Lazy(false)
@Component
public class Timing {
	@Autowired
	private DbUserDiscountsMapper userDiscountsMapper;
	@Autowired
	private DbDiscountsMapper discountsMapper;
	@Autowired
	private DbActivityMapper activityMapper;
	@Autowired
	private DbFoodMapper dbFoodMapper;

	/**
	 * 每天凌晨执行检验用户手中的优惠券是否到期
	 */
	@Scheduled(cron = "0 0 0 * * ? ")
	public void de() {
		EntityWrapper<DbDiscounts>wrapper=new EntityWrapper<>();
		EntityWrapper<DbUserDiscounts> uWrapper=new EntityWrapper<>();
		EntityWrapper<DbActivity>aWrapper=new EntityWrapper<>();
		List<DbDiscounts>list=discountsMapper.selectList(wrapper);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format( now ); //獲取當前日期
		for (DbDiscounts dbDiscounts : list) {
			if(dbDiscounts.getdOvertime().compareTo(time)==-1) {//對比優惠券與當前日期過期刪除
				discountsMapper.deleteById(dbDiscounts.getdId());
				uWrapper.eq("ud_discountsid", dbDiscounts.getdId());
				userDiscountsMapper.delete(uWrapper);
				aWrapper.eq("activity_to_discounts", dbDiscounts.getdId());
				activityMapper.delete(aWrapper);
			}
		}
	}
	/**
	 * 每个月最后一天执行清空菜品的月销售额
	 */
	@Scheduled(cron = "0 0 0 1 * ?")
	public void clean() {
		EntityWrapper<DbFood>wrapper=new EntityWrapper<>();
		dbFoodMapper.updateForSet("f_month=0", wrapper);
	}
}
