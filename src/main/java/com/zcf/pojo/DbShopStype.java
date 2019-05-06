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
public class DbShopStype extends Model<DbShopStype> {

    private static final long serialVersionUID = 1L;

    /**
     * 商铺id
     */
    private String sstShopid;
    /**
     * 商铺类型id
     */
    private Integer sstStid;


    public String getSstShopid() {
        return sstShopid;
    }

    public void setSstShopid(String sstShopid) {
        this.sstShopid = sstShopid;
    }

    public Integer getSstStid() {
        return sstStid;
    }

    public void setSstStid(Integer sstStid) {
        this.sstStid = sstStid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "DbShopStype{" +
        "sstShopid=" + sstShopid +
        ", sstStid=" + sstStid +
        "}";
    }
}
