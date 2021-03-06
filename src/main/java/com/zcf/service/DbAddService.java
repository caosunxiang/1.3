package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbAdd;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbAddService extends IService<DbAdd> {

	Body getbyfid(String fid);

	Body getall();

	Body up(DbAdd add);//修改

	Body de(String aid);//刪除

	Body add(DbAdd add);//添加

}
