package com.zcf.ServiceImpl;

import com.zcf.pojo.DbCode;
import com.zcf.code.QRCodeUtil;
import com.zcf.common.json.Body;
import com.zcf.common.utils.Hutool;
import com.zcf.common.utils.JsonUtils;
import com.zcf.mapper.DbCodeMapper;
import com.zcf.service.DbCodeService;
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
 * @since 2019-06-06
 */
@Service
public class DbCodeServiceImpl extends ServiceImpl<DbCodeMapper, DbCode> implements DbCodeService {
@Autowired
private DbCodeMapper dbCodeMapper;
   @Override
   public Body addcode(String sid ,Integer table) {
	   DbCode dbCode=new DbCode();
	   dbCode.setCodeToShop(sid);
	   dbCode.setTable(table);
	  String txt=null;
	try {
		txt = JsonUtils.beanToJson(dbCode);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
//	   String txt="http://127.0.0.1:8080/1.3/index.html?sid="+sid+"&table="+table;
	   String file="";
	try {
		file = QRCodeUtil.encode(txt, null ,"C:/read/files/images", false);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	   String url="http://47.97.163.4:6058/images/" +file;
	   String url="http://127.0.0.1:8080/images/" +file;
	   DbCode code=new DbCode();
	   code.setCodeToShop(sid);
	   code.setcPic(url);
	   code.setTable(table);
	   code.setcId(Hutool.getId());
	   dbCodeMapper.insert(code);
	   return Body.newInstance(url);
   }
   @Override
   public Body getall(String sid) {
	   EntityWrapper<DbCode>wrapper=new EntityWrapper<>();
	   if(!StringUtils.isEmpty(sid)) {
		   wrapper.eq("code_to_shop", sid);
	   }
	   List<DbCode>list=dbCodeMapper.selectList(wrapper);
	   if(list.size()>0) {
		   return Body.newInstance(list);
	   }  
	   return Body.newInstance(201, "查询无果");
   }
  @Override
  public Body de(String sid) {
	  Integer count=dbCodeMapper.deleteById(sid);
	  if(count==1) {
		  return Body.BODY_200;
	  }
	  return Body.BODY_451;
  }
}
