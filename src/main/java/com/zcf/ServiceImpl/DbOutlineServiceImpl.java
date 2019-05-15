package com.zcf.ServiceImpl;

import com.zcf.pojo.DbOutline;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbOutlineMapper;
import com.zcf.service.DbOutlineService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-25
 */
@Service
public class DbOutlineServiceImpl extends ServiceImpl<DbOutlineMapper, DbOutline> implements DbOutlineService {
	@Autowired
	private DbOutlineMapper outlineMapper;

	@Override
	public Body getall() {
		EntityWrapper<DbOutline> wrapper = new EntityWrapper<DbOutline>();
		List<DbOutline> list = outlineMapper.selectList(wrapper);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "沒有評論大綱");
	}
	
	
	@Override
	public Body add(DbOutline dbOutline) {
		Integer count=outlineMapper.insert(dbOutline);
		if(count==1) {
			return Body.newInstance(dbOutline);
		}
		return Body.newInstance(201, "添加失敗");
	}
	@Override
	public Body up(String lid,String lcontent) {
		EntityWrapper<DbOutline> wrapper=new EntityWrapper<>();
		wrapper.eq("l_id", lid);
		Integer count=outlineMapper.updateForSet("l_content='"+lcontent+"'", wrapper);
		if(count==1) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "修改失敗");
	}
	
	@Override
	public Body de(String lid) {
		Integer count=outlineMapper.deleteById(lid);
		if(count==1) {
			return Body.BODY_200;
		}
		return Body.newInstance(201, "刪除失敗");
	}
	@Override
	public Body bysid(String sid) {
		List<DbOutline> list=outlineMapper.bysid(sid);
		if(list.size()>0) {
			return Body.newInstance(list);
		}
		return Body.newInstance(201, "查詢無果");
	}
}
