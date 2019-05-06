package com.zcf.ServiceImpl;

import com.zcf.pojo.DbCustom;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbCustomMapper;
import com.zcf.service.DbCustomService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@Service
public class DbCustomServiceImpl extends ServiceImpl<DbCustomMapper, DbCustom> implements DbCustomService {
	@Autowired
	private DbCustomMapper dbCustomMapper;

	@Override
	public Body getbyfid(String fid) {
		List<DbCustom> list = dbCustomMapper.getbyfid(fid);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "菜品未设置自定");
	}
	@Override
	public Body getall() {
		EntityWrapper<DbCustom>wrapper=new EntityWrapper<>();
		List< DbCustom> list=selectList(wrapper);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201,"没有结果");
	}
}
