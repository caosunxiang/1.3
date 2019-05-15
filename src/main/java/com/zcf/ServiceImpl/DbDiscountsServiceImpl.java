package com.zcf.ServiceImpl;

import com.zcf.pojo.DbDiscounts;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbDiscountsMapper;
import com.zcf.service.DbDiscountsService;
import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

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
public class DbDiscountsServiceImpl extends ServiceImpl<DbDiscountsMapper, DbDiscounts> implements DbDiscountsService {
@Autowired
private DbDiscountsMapper discountsMapper;
@Override
public Body getbysid(String sid) {
	EntityWrapper< DbDiscounts>wrapper=new EntityWrapper<>();
	if(!StringUtils.isEmpty(sid)) {
		wrapper.eq("discounts_to_shop", sid);
	}
	List<DbDiscounts> list=discountsMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "沒有發佈優惠券");
}
@Override
public Body getbyuid(String uid) {
	List<DbDiscounts>list=discountsMapper.getbyuid(uid);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "沒有優惠券");
}
@Override
public Body sidtouid(String sid,String uid) {
	List<DbDiscounts>list=discountsMapper.sidtouid(sid, uid);
	if(list.size()>0) {
		return Body.newInstance(list); 
	}
	return Body.newInstance(201, "您尚未獲得該商家的優惠券");
}

}
