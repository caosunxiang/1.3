package com.zcf.mapper;

import com.zcf.pojo.DbSet;

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
public interface DbSetMapper extends BaseMapper<DbSet> {
 List<DbSet> getbyfid(@Param("fid")String fid);
}
