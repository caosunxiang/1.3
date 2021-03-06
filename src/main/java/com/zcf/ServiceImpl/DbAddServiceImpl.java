package com.zcf.ServiceImpl;

import com.zcf.pojo.DbAdd;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbAddMapper;
import com.zcf.service.DbAddService;
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
public class DbAddServiceImpl extends ServiceImpl<DbAddMapper, DbAdd> implements DbAddService {
@Autowired
private DbAddMapper dbAddMapper;
@Override
public Body getbyfid(String fid) {
	List< DbAdd >list =dbAddMapper.getbyfid(fid);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "此菜品没有设置加配");
}
@Override
public Body getall() {
	EntityWrapper<DbAdd>wrapper=new EntityWrapper<>();
	List<DbAdd>list=dbAddMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "没有查到结果");
}
@Override
public Body add(DbAdd add) {
	Integer count=dbAddMapper.insert(add);
	if(count==1) {
		return Body.newInstance(add);
	}
	return Body.newInstance(201, "添加失敗");
}
@Override
public Body de(String aid) {
	Integer count=dbAddMapper.deleteById(aid);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "刪除失敗");
}
@Override
public Body up(DbAdd add) {
	Integer count=dbAddMapper.updateById(add);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "修改失敗");
}
}
