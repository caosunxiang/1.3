package com.zcf.ServiceImpl;

import com.zcf.pojo.DbFast;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbFastMapper;
import com.zcf.service.DbFastService;
import com.alipay.api.internal.util.StringUtils;
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
 * @since 2019-04-29
 */
@Service
public class DbFastServiceImpl extends ServiceImpl<DbFastMapper, DbFast> implements DbFastService {
	@Autowired
	private DbFastMapper dbFastMapper;

	@Override
	public Body getall() {
		EntityWrapper<DbFast> wrapper = new EntityWrapper<>();
		List<DbFast> list = dbFastMapper.selectList(wrapper);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}

	@Override
	public Body add( String fName, String fCount) {
		DbFast dbFast = new DbFast();
		dbFast.setfName(fName);
		dbFast.setfCount(fCount);
		dbFastMapper.insert(dbFast);

		return Body.BODY_200;

	}
 
	@Override
	public Body del(Integer fId) {
		Integer count = dbFastMapper.deleteById(fId);
		if (count == 1) {
			return Body.BODY_200;
		}
		return Body.BODY_400;
	}

	@Override
	public Body upd(Integer fId, String fName, String fCount) {
		DbFast dbFast = new DbFast();
		dbFast.setfId(fId);
		dbFast.setfName(fName);
		dbFast.setfCount(fCount);
		dbFastMapper.updateById(dbFast);
		return Body.BODY_200;
	}

	@Override
	public Body getone(Integer fId) {
		DbFast dbFast = dbFastMapper.selectById(fId);
		if (dbFast != null) {
			return Body.newInstance(dbFast);
		}
		return Body.BODY_400;
	}

}