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
public class DbOrderFood extends Model<DbOrderFood> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品订单id
     */
    private String ofOrderid;
    /**
     * 订单菜品id
     */
    private String ofFoodid;


    public String getOfOrderid() {
        return ofOrderid;
    }

    public void setOfOrderid(String ofOrderid) {
        this.ofOrderid = ofOrderid;
    }

    public String getOfFoodid() {
        return ofFoodid;
    }

    public void setOfFoodid(String ofFoodid) {
        this.ofFoodid = ofFoodid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "DbOrderFood{" +
        "ofOrderid=" + ofOrderid +
        ", ofFoodid=" + ofFoodid +
        "}";
    }
}
