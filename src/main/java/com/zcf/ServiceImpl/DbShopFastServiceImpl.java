package com.zcf.ServiceImpl;

import com.zcf.pojo.DbShopFast;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbShopFastMapper;
import com.zcf.service.DbShopFastService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-29
 */
@Service
public class DbShopFastServiceImpl extends ServiceImpl<DbShopFastMapper, DbShopFast> implements DbShopFastService {
@Autowired
private DbShopFastMapper dbShopFastMapper;
@Override
public Body  label(DbShopFast dbShopFast) {
	Integer count=dbShopFastMapper.insert(dbShopFast);
	if(count==1) {
		return Body.newInstance(dbShopFast);
	}
	return Body.newInstance(201, "添加失敗");
}
}
