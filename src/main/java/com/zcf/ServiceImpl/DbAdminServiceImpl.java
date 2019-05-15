package com.zcf.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbAdminMapper;
import com.zcf.pojo.DbAdmin;
import com.zcf.service.DbAdminService;
@Service
public class DbAdminServiceImpl  extends ServiceImpl<DbAdminMapper, DbAdmin> implements DbAdminService{
@Autowired
private DbAdminMapper dbAdminMapper;
	@Override
	public Body login(String aId, String aPwd) {
		DbAdmin admin=dbAdminMapper.selectById(aId);
		if(admin!=null&&admin.getaPwd().equals(aPwd)){
			return Body.newInstance(admin);
		}	
          return Body.BODY_400;
	}

}