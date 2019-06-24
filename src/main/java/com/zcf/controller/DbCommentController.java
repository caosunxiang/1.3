package com.zcf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.internal.util.StringUtils;
import com.zcf.common.json.Body;
import com.zcf.common.result.ResultVo;
import com.zcf.common.utils.Hutool;
import com.zcf.pojo.DbComment;
import com.zcf.pojo.DbCustom;
import com.zcf.service.DbCommentService;
import com.zcf.utils.IDUtils;
import com.zcf.vo.in.PageVo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/dbComment")
@CrossOrigin
public class DbCommentController {
	@Autowired
	private DbCommentService commentService;

	/**
	 * 添加品論
	 * 
	 * @param content
	 * @param score
	 * @param co
	 * @param table
	 * @param otime
	 * @param cu
	 * @param head
	 * @param cs
	 * @param sname
	 * @param sename
	 * @return
	 */
	@PostMapping("/comadd")
	public Body comadd(String content, Integer score, String co, String table, String otime, String cu, String head,
			String cs, String sname, String sename,String cl,String ccontent,String cuname) {
		if (StringUtils.isEmpty(content) || score == null || StringUtils.isEmpty(co) || StringUtils.isEmpty(table)
				|| StringUtils.isEmpty(otime) || StringUtils.isEmpty(cu) || StringUtils.isEmpty(cs)
				|| StringUtils.isEmpty(sname) || StringUtils.isEmpty(sename)|| StringUtils.isEmpty(cuname)) {
			return Body.BODY_451;
		}
		DbComment comment = new DbComment();
		comment.setcContent(content);
		comment.setcId(Hutool.getId());
		comment.setCommentToOrder(co);
		comment.setCommentToShop(cs);
		comment.setCommentToUser(cu);
		comment.setcOrderTable(table);
		comment.setcOrderTime(Hutool.parseDateToString());
		comment.setcScore(score);
		comment.setcShopEname(sename);
		comment.setcShopName(sname);
		comment.setcTime(otime);
		comment.setcUserHead(head);
		comment.setcUserName(cuname);
		comment.setCommentToLine(cl);
		comment.setcLineContent(ccontent);
		return commentService.comadd(comment);
	}

	/**
	 * 查看商家的評論
	 * @param sid
	 * @return
	 */
	@PostMapping("/getbysid")
	ResultVo getbysid(String sid,PageVo pv) {
		
		return commentService.getbysid(sid, pv);
	}

	/**
	 * 查看用戶的評論
	 * @param uid
	 * @return
	 */
	@PostMapping("/getbyuid")
	Body getbyuid(String uid) {
		if (StringUtils.isEmpty(uid)) {
			return Body.BODY_451;
		}
		return commentService.getbyuid(uid);
	}
	/**
	 * 各種分數個數
	 * @param sid
	 * @return
	 */
	@PostMapping("/count")
	Body count(String sid) {
		if(StringUtils.isEmpty(sid)) {
			return Body.BODY_451;
		}
		return commentService.count(sid);
	}
	/**
	 * 回復評論
	 * @param cid
	 * @param remark
	 * @return
	 */
	@PostMapping("/remark")
	Body remark(String cid, String remark) {
		if(StringUtils.isEmpty(cid)||StringUtils.isEmpty(remark)) {
			return Body.BODY_451;
		}
		return commentService.remark(cid, remark);
	}
	/**
	 * 置顶
	 * @param cid
	 * @param cup
	 * @return
	 */
	@PostMapping("/cup")
	Body cup(String cid, String cup) {
		if(StringUtils.isEmpty(cid)||StringUtils.isEmpty(cup)) {
			return Body.BODY_451;
		}
		return commentService.cup(cid, cup);
	}
}
