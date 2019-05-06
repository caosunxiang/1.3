package com.zcf.ServiceImpl;

import com.zcf.pojo.DbComment;
import com.zcf.pojo.DbOutline;
import com.zcf.common.json.Body;
import com.zcf.mapper.DbCommentMapper;
import com.zcf.mapper.DbOutlineMapper;
import com.zcf.service.DbCommentService;
import com.alipay.api.internal.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class DbCommentServiceImpl extends ServiceImpl<DbCommentMapper, DbComment> implements DbCommentService {
@Autowired
private DbCommentMapper commentMapper;
@Autowired
private DbOutlineMapper outlineMapper ;
@Override
public Body comadd(DbComment comment) {
	Integer count=commentMapper.insert(comment);
	if(count==1) {
		String lid=comment.getCommentToLine();
		if(!StringUtils.isEmpty(lid)) {
			DbOutline dbOutline=outlineMapper.selectById(lid);
			//如果評論中有快捷評論那就增加快捷評論次數
			Integer num=dbOutline.getlNum();
			dbOutline.setlNum(num++);
		}
		return Body.newInstance(comment);
	}
	return Body.newInstance(201, "添加失敗");
}
@Override
public Body getbysid(String sid) {
	EntityWrapper< DbComment>wrapper=new EntityWrapper<>();
	wrapper.eq("comment_to_shop", sid);
	List<DbComment> list=commentMapper.selectList(wrapper);
	if(list.size()>0) {
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "沒有更多評論了");
}
@Override
public Body getbyuid(String uid) {
	EntityWrapper<DbComment>wrapper=new EntityWrapper<>();
	wrapper.eq("comment_to_user", uid);
	List<DbComment>list=commentMapper.selectList(wrapper);
	if(list.size()>0) {		
		return Body.newInstance(list);
	}
	return Body.newInstance(201, "你還有有評論過商家");
}
@Override
public Body count(String sid) {
	EntityWrapper<DbComment> wrapper5=new EntityWrapper<>();
	wrapper5.eq("comment_to_shop", sid);
    wrapper5.eq("c_score", 5);
    Map<Integer, Integer > map=new HashMap<>();
	Integer count5=commentMapper.selectCount(wrapper5);
	map.put(5, count5);
	EntityWrapper<DbComment> wrapper3=new EntityWrapper<>();
	wrapper3.eq("comment_to_shop", sid);
    wrapper3.eq("c_score", 3);
    Integer count3=commentMapper.selectCount(wrapper3);
    map.put(3, count3);
    EntityWrapper<DbComment> wrapper1=new EntityWrapper<>();
	wrapper1.eq("comment_to_shop", sid);
    wrapper1.eq("c_score", 1);
    Integer count1=commentMapper.selectCount(wrapper1);
    map.put(1, count1);
    return Body.newInstance(map);
}
@Override
public Body remark(String cid,String remark) {
	EntityWrapper<DbComment>wrapper=new EntityWrapper<>();
	wrapper.eq("c_id", cid);
	Integer count=commentMapper.updateForSet("c_reply='"+remark+"'", wrapper);
	if(count==1) {
		return Body.BODY_200;
	}
	return Body.newInstance(201, "回復失敗");
}
}
