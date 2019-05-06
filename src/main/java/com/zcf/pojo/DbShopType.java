package com.zcf.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 曹孙翔
 * @since 2019-04-22
 */
public class DbShopType extends Model<DbShopType> {

    private static final long serialVersionUID = 1L;

    /**
     * 商铺类型id
     */
    @TableId(value = "st_id", type = IdType.AUTO)
    private Integer stId;
    /**
     * 商铺类型名称
     */
    private String stName;


    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    @Override
    protected Serializable pkVal() {
        return this.stId;
    }

    @Override
    public String toString() {
        return "DbShopType{" +
        "stId=" + stId +
        ", stName=" + stName +
        "}";
    }
}
