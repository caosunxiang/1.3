package com.zcf.ServiceImpl;

import com.zcf.pojo.DbDiscounts;
import com.zcf.pojo.DbUserDiscounts;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbDiscountsMapper;
import com.zcf.mapper.DbUserDiscountsMapper;
import com.zcf.service.DbUserDiscountsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@Service
public class DbUserDiscountsServiceImpl extends ServiceImpl<DbUserDiscountsMapper, DbUserDiscounts> implements DbUserDiscountsService {
@Autowired
private DbUserDiscountsMapper discountsMapper;
@Autowired
private DbDiscountsMapper dbDiscountsMapper;
@Override
public Body addud(DbUserDiscounts dbUserDiscounts) {
	EntityWrapper<DbUserDiscounts> wrapper=new EntityWrapper<>();
	wrapper.eq("ud_userid", dbUserDiscounts.getUdUserid());
	wrapper.eq("ud_discountsid", dbUserDiscounts.getUdDiscountsid());
	DbDiscounts dbDiscounts=dbDiscountsMapper.selectById(dbUserDiscounts.getUdDiscountsid());
	if(dbDiscounts!=null) {
		Integer count=discountsMapper.selectCount(wrapper);
		if(count<dbDiscounts.getdMaximum()) {
			discountsMapper.insert(dbUserDiscounts);
			return Body.newInstance(200, "優惠券領取成功");
		}else {
			return Body.newInstance(201, "优惠券已超过上限");
		}
	}else {
		return Body.newInstance(201, "优惠券已不存在");
	}
}
@Override
public Body discount(String openid) {
	EntityWrapper<DbUserDiscounts> wrapper=new EntityWrapper<>();
	wrapper.eq("ud_userid", openid);
	Integer count=selectCount(wrapper);
	if(count!=0) {
		return Body.newInstance(count);
	}
	return Body.newInstance(201, "沒有已領取的優惠券");
}
}
