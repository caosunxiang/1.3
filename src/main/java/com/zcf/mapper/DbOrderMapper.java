package com.zcf.mapper;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbOrder;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbOrderMapper extends BaseMapper<DbOrder> {
List<Map<String, Object> >getone(@Param("oid")String oid);
List<Map<String, Object> >getbyuid(@Param("uid")String uid);
List<Map<String, Object> >getbysid(@Param("sid")String sid);
List<DbOrder>today();
List<Map<String, Object> >finishone(@Param("oid")String oid);
List< Map<String, Object>>bytable(@Param("table")String table,@Param("sid")String sid);
//小时
int onehour();
int towhour();
int threehour();
int fourhour();
//获取前七天的定单数
Map<String , Integer> sevenago();

//天
int todaycount();
int oneday();
int towday();
int threeday();
//获取七小时钱的订单数
Map<String, Integer>sevenhour();
}
