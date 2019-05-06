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
public class DbUserDiscounts extends Model<DbUserDiscounts> {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠券用户id
     */
    private String udUserid;
    /**
     * 用户优惠券id
     */
    private String udDiscountsid;


    public String getUdUserid() {
        return udUserid;
    }

    public void setUdUserid(String udUserid) {
        this.udUserid = udUserid;
    }

    public String getUdDiscountsid() {
        return udDiscountsid;
    }

    public void setUdDiscountsid(String udDiscountsid) {
        this.udDiscountsid = udDiscountsid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "DbUserDiscounts{" +
        "udUserid=" + udUserid +
        ", udDiscountsid=" + udDiscountsid +
        "}";
    }
}
