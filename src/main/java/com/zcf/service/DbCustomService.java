package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbCustom;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbCustomService extends IService<DbCustom> {

	Body getbyfid(String fid);//根据菜品查自定

	Body getall();// 查询全部的自定菜单

	Body add(DbCustom custom);//添加

	Body de(String cid);//刪除

	Body up(DbCustom custom);//修改

	Body getone(String cid);//唯一查詢

}
