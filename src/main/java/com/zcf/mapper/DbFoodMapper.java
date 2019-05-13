package com.zcf.mapper;

import com.zcf.pojo.DbFood;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbFoodMapper extends BaseMapper<DbFood> {
List<Map<String, Object>>percentage();
}
