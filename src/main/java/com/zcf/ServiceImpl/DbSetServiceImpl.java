package com.zcf.ServiceImpl;

import com.zcf.pojo.DbSet;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbSetMapper;
import com.zcf.service.DbSetService;
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
public class DbSetServiceImpl extends ServiceImpl<DbSetMapper, DbSet> implements DbSetService {
@Autowired
private DbSetMapper dbSetMapper;
@Override
public Body getbyfid(String fid) {
	List< DbSet> list=dbSetMapper.getbyfid(fid);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "该商品没有设置配套");
}
@Override
public Body getall() {
	EntityWrapper<DbSet>wrapper=new EntityWrapper<>();
	List<DbSet>list=dbSetMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "没有查询到结果");
}
}
