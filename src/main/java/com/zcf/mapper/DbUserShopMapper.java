package com.zcf.mapper;

import com.zcf.pojo.DbUserShop;

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
public interface DbUserShopMapper extends BaseMapper<DbUserShop> {
public List<Map<String,Object>> byopenid(@Param("uid")String openid);
}
