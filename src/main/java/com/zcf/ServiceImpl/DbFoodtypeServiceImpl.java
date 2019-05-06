package com.zcf.ServiceImpl;

import com.zcf.pojo.DbFoodtype;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFoodtypeMapper;
import com.zcf.service.DbFoodtypeService;
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
public class DbFoodtypeServiceImpl extends ServiceImpl<DbFoodtypeMapper, DbFoodtype> implements DbFoodtypeService {
@Autowired
private DbFoodtypeMapper dbFoodtypeMapper;
@Override
public Body getall(String sid) {
	EntityWrapper<DbFoodtype> wrapper=new EntityWrapper<>();
	if(!StringUtils.isEmpty(sid)) {
		wrapper.eq("foodtype_to_shop", sid);
	}
	List<DbFoodtype> list=dbFoodtypeMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "店鋪沒有設置分類");
}
}
