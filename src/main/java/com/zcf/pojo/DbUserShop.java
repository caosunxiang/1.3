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
public class DbUserShop extends Model<DbUserShop> {

    private static final long serialVersionUID = 1L;

    /**
     * 商铺用户id
     */
    private String usUserid;
    /**
     * 用户商铺id
     */
    private String usShopid;


    public String getUsUserid() {
        return usUserid;
    }

    public void setUsUserid(String usUserid) {
        this.usUserid = usUserid;
    }

    public String getUsShopid() {
        return usShopid;
    }

    public void setUsShopid(String usShopid) {
        this.usShopid = usShopid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "DbUserShop{" +
        "usUserid=" + usUserid +
        ", usShopid=" + usShopid +
        "}";
    }
}
