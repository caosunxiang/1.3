package com.zcf.pojo;

import java.math.BigDecimal;
import java.util.Date;
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
public class DbStrolley extends Model<DbStrolley> {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车id
     */
    @TableId(value = "strolley_id", type = IdType.NONE)
    private String strolleyId;
    /**
     * 点餐桌号
     */
    private String strolleyTable;
    /**
     * 购物车关联食物
     * */
    private String strolleyToFood;
    /**
     * 食物名称
     */
    private String strolleyFoodName;
    /**
     * 食物英文名
     */
    private String strolleyFoodEname;
    /**
     * 菜品数量
     */
    private Integer strolleyNum;
    /**
     * 菜品价格
     */
    private BigDecimal strolleyPrice;
    /**
     * 菜品总价
     */
    private BigDecimal strolleyTotal;
    /**
     * 菜品备注
     */
    private String strolleyRemark;
    /**
     * 加入购物车时间
     */
    private String strolleyTime;
    /**
     * 购物车关联用户
     */
    private String strolleyToUser;
    /**
     * 购物车关联商铺
     */
    private String strolleyToShop;
    /**
     * 店铺名称
     */
    private String strolleyShopName;
    /**
     * 店铺英文名称
     */
    private String strolleyShopEname;


    public String getStrolleyId() {
        return strolleyId;
    }

    public void setStrolleyId(String strolleyId) {
        this.strolleyId = strolleyId;
    }

    public String getStrolleyTable() {
        return strolleyTable;
    }

    public void setStrolleyTable(String strolleyTable) {
        this.strolleyTable = strolleyTable;
    }

    public String getStrolleyToFood() {
		return strolleyToFood;
	}

	public void setStrolleyToFood(String strolleyToFood) {
		this.strolleyToFood = strolleyToFood;
	}

	public String getStrolleyFoodName() {
        return strolleyFoodName;
    }

    public void setStrolleyFoodName(String strolleyFoodName) {
        this.strolleyFoodName = strolleyFoodName;
    }

    public String getStrolleyFoodEname() {
        return strolleyFoodEname;
    }

    public void setStrolleyFoodEname(String strolleyFoodEname) {
        this.strolleyFoodEname = strolleyFoodEname;
    }

    public Integer getStrolleyNum() {
        return strolleyNum;
    }

    public void setStrolleyNum(Integer strolleyNum) {
        this.strolleyNum = strolleyNum;
    }

    public BigDecimal getStrolleyPrice() {
        return strolleyPrice;
    }

    public void setStrolleyPrice(BigDecimal strolleyPrice) {
        this.strolleyPrice = strolleyPrice;
    }

    public BigDecimal getStrolleyTotal() {
        return strolleyTotal;
    }

    public void setStrolleyTotal(BigDecimal strolleyTotal) {
        this.strolleyTotal = strolleyTotal;
    }

    public String getStrolleyRemark() {
        return strolleyRemark;
    }

    public void setStrolleyRemark(String strolleyRemark) {
        this.strolleyRemark = strolleyRemark;
    }

    public String getStrolleyTime() {
        return strolleyTime;
    }

    public void setStrolleyTime(String strolleyTime) {
        this.strolleyTime = strolleyTime;
    }

    public String getStrolleyToUser() {
        return strolleyToUser;
    }

    public void setStrolleyToUser(String strolleyToUser) {
        this.strolleyToUser = strolleyToUser;
    }

    public String getStrolleyToShop() {
        return strolleyToShop;
    }

    public void setStrolleyToShop(String strolleyToShop) {
        this.strolleyToShop = strolleyToShop;
    }

    public String getStrolleyShopName() {
        return strolleyShopName;
    }

    public void setStrolleyShopName(String strolleyShopName) {
        this.strolleyShopName = strolleyShopName;
    }

    public String getStrolleyShopEname() {
        return strolleyShopEname;
    }

    public void setStrolleyShopEname(String strolleyShopEname) {
        this.strolleyShopEname = strolleyShopEname;
    }

    @Override
    protected Serializable pkVal() {
        return this.strolleyId;
    }

    @Override
    public String toString() {
        return "DbStrolley{" +
        "strolleyId=" + strolleyId +
        ", strolleyTable=" + strolleyTable +
        ", strolleyFoodName=" + strolleyFoodName +
        ", strolleyFoodEname=" + strolleyFoodEname +
        ", strolleyNum=" + strolleyNum +
        ", strolleyPrice=" + strolleyPrice +
        ", strolleyTotal=" + strolleyTotal +
        ", strolleyRemark=" + strolleyRemark +
        ", strolleyTime=" + strolleyTime +
        ", strolleyToUser=" + strolleyToUser +
        ", strolleyToShop=" + strolleyToShop +
        ", strolleyShopName=" + strolleyShopName +
        ", strolleyShopEname=" + strolleyShopEname +
        "}";
    }
}
