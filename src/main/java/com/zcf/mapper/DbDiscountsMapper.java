package com.zcf.mapper;

import com.zcf.pojo.DbDiscounts;

import java.util.List;

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
public interface DbDiscountsMapper extends BaseMapper<DbDiscounts> {
List<DbDiscounts> getbyuid(@Param("uid")String uid);
List<DbDiscounts> sidtouid(@Param("sid")String sid,@Param("uid")String uid);
}
