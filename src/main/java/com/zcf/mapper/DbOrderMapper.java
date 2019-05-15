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

//小时
int onehour();
int towhour();
int threehour();
int fourhour();


//天
int todaycount();
int oneday();
int towday();
int threeday();

}
