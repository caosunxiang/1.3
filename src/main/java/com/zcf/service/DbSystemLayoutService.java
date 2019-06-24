package com.zcf.service;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbSystemLayout;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzhuang
 * @since 2019-05-16
 */
public interface DbSystemLayoutService extends IService<DbSystemLayout> {

	Body one();//查詢夥計頁面彈窗內容

	Body two();//查詢搜索框以上的內容

	Body three();//查詢搜索框以下的內容

	Body upone(String str,String id);//修改夥計頁面彈窗內容

	Body uptwo(String str);//修改搜索框以上的內容

	Body upthree(String str);//修改搜索框以下的內容

	Body getall();//查詢全部系統配置信息

	Body getone(Integer slid);

}
