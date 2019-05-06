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
 * @since 2019-04-29
 */
public class DbShopFast extends Model<DbShopFast> {

    private static final long serialVersionUID = 1L;

    /**
     * 店鋪標籤店鋪id
     */
    private String sfShopid;
    /**
     * 標籤id
     */
    private Integer sfFastid;


    public String getSfShopid() {
        return sfShopid;
    }

    public void setSfShopid(String sfShopid) {
        this.sfShopid = sfShopid;
    }

    public Integer getSfFastid() {
        return sfFastid;
    }

    public void setSfFastid(Integer sfFastid) {
        this.sfFastid = sfFastid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "DbShopFast{" +
        "sfShopid=" + sfShopid +
        ", sfFastid=" + sfFastid +
        "}";
    }
}
