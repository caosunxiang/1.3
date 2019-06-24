package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbOutline;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-25
 */
public interface DbOutlineService extends IService<DbOutline> {

	Body getall();//獲取全部的評論大綱

	Body add(DbOutline dbOutline);//添加大綱

	Body up(String lid, String lcontent,Integer lNum);//修改大綱

	Body de(String lid);//刪除大綱

	Body bysid(String sid);//大綱按次數排序

	Body getone(String lid);//唯一查詢

}
