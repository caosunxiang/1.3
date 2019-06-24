package com.zcf.mapper;

import com.zcf.pojo.DbActivity;

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
 * @since 2019-04-26
 */
public interface DbActivityMapper extends BaseMapper<DbActivity> {
Map<String, Object> getbyaid(@Param("aid")Integer aid);
List<Map<String, Object>>near();
}
