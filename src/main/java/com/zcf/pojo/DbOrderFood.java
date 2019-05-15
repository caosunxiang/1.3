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
    /**
     * 菜品备注
     * */
    private String ofRemark;
    /**
     * 菜品价格
     * */
    private String ofPrice;


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

    public String getOfRemark() {
		return ofRemark;
	}

	public void setOfRemark(String ofRemark) {
		this.ofRemark = ofRemark;
	}

	public String getOfPrice() {
		return ofPrice;
	}

	public void setOfPrice(String ofPrice) {
		this.ofPrice = ofPrice;
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
