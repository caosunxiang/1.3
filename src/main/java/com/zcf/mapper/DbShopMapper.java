package com.zcf.mapper;

import com.zcf.pojo.DbShop;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public interface DbShopMapper extends BaseMapper<DbShop> {
	List<Map<String, Object>> shop(@Param("fid") List<Integer> fid,
			@Param("name") String name, @Param("ave1") BigDecimal ave1,
			@Param("ave2") BigDecimal ave2);
	
	DbShop phone(@Param("phone")String phone);
	
	
	
}
