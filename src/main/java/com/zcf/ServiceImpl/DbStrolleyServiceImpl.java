package com.zcf.ServiceImpl;

import com.zcf.pojo.DbStrolley;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbStrolleyMapper;
import com.zcf.service.DbStrolleyService;
import com.zcf.utils.From;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@Service
public class DbStrolleyServiceImpl extends ServiceImpl<DbStrolleyMapper, DbStrolley> implements DbStrolleyService {
	@Autowired
	private DbStrolleyMapper strolleyMapper;

	@Override
	public Body addst(DbStrolley dbStrolley) {
		Integer count = strolleyMapper.insert(dbStrolley);
		if (count == 1) {
			return Body.newInstance(dbStrolley);

		}
		return Body.newInstance(201, "添加失敗");
	}

	@Override
	public Body userst(String uid, String sid) {
		EntityWrapper<DbStrolley> wrapper = new EntityWrapper<>();
		wrapper.eq("strolley_to_user", uid);
		wrapper.eq("strolley_to_shop", sid);
		List<DbStrolley> list = strolleyMapper.selectList(wrapper);
		if (list.size() > 0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "購物籃還沒有添加商品");
	}

	@Override
	public Body dest(String stid) {
		Integer count = strolleyMapper.deleteById(stid);
		if (count == 1) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "刪除失敗");
	}
	@Override
	public Body deall(List<String >  stid) {
		Integer count=strolleyMapper.deleteBatchIds(stid);
		if(count!=0) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "刪除失敗");
	}
}
