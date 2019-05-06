package com.zcf.mapper;

import com.zcf.common.json.Body;
import com.zcf.pojo.DbOutline;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-25
 */
public interface DbOutlineMapper extends BaseMapper<DbOutline> {
	List<DbOutline> bysid(@Param("sid")String sid);
}
