package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.common.result.ResultVo;
import com.zcf.pojo.DbComment;
import com.zcf.vo.in.PageVo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbCommentService extends IService<DbComment> {

	Body comadd(DbComment comment);//添加訂單評論

	ResultVo getbysid(String sid,PageVo pv);//查詢店鋪的評論

	Body getbyuid(String uid);//查詢個人的評論

	Body count(String sid);//各種分數個數

	Body remark(String cid, String remark);//回復用戶評論

	Body cup(String cid, String cup);//置顶
	
}
