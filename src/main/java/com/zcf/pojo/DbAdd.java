package com.zcf.pojo;

import java.math.BigDecimal;
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
public class DbAdd extends Model<DbAdd> {

    private static final long serialVersionUID = 1L;

    /**
     * 加配id
     */
    @TableId(value = "add_id", type = IdType.NONE)
    private String addId;
    private String addName;
    /**
     * 加配英文名
     */
    private String addEnglish;
    /**
     * 加配价格
     */
    private BigDecimal addPrice;
    /**
     * 加配状态
     */
    private String addState;
    /**
     * 所属商铺
     * */
    private String addShop;


    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public String getAddEnglish() {
        return addEnglish;
    }

    public void setAddEnglish(String addEnglish) {
        this.addEnglish = addEnglish;
    }

    public BigDecimal getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(BigDecimal addPrice) {
        this.addPrice = addPrice;
    }

    public String getAddState() {
        return addState;
    }

    public void setAddState(String addState) {
        this.addState = addState;
    }

    public String getAddShop() {
		return addShop;
	}

	public void setAddShop(String addShop) {
		this.addShop = addShop;
	}

	@Override
    protected Serializable pkVal() {
        return this.addId;
    }

    @Override
    public String toString() {
        return "DbAdd{" +
        "addId=" + addId +
        ", addName=" + addName +
        ", addEnglish=" + addEnglish +
        ", addPrice=" + addPrice +
        ", addState=" + addState +
        "}";
    }
}
