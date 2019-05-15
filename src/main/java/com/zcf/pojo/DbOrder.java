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
public class DbOrder extends Model<DbOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "o_id", type = IdType.NONE)
    private String oId;
    /**
     * 订单购物车桌号
     */
    private String oStrolleyTable;
    /**
     * 订单小计
     */
    private BigDecimal oSubtotal;
    /**
     * 订单服务费
     */
    private BigDecimal oServiceCharge;
    /**
     * 优惠券
     */
    private String oDiscounts;
    /**
     * 订单优惠券金额
     */
    private BigDecimal oDiscountsPrice;
    /**
     * 订单优惠券描述
     */
    private String oDiscountsRemark;
    /**
     * 订单状态
     */
    private String oState;
    /**
     * 订单总计
     */
    private BigDecimal oTotal;
    /**
     * 订单生成时间
     */
    private String oTime;
    /**
     * 就餐结束时间
     * */
    private String oOvertime;
    /**
     * 订单关联用户
     */
    private String orderToUser;
    /**
     * 订单关联店铺
     */
    private String orderToShop;
    /**
     * 订单商铺名称
     */
    private String oShopName;
    /**
     * 订单商铺英文名称
     */
    private String oShopEname;
  
    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getoStrolleyTable() {
        return oStrolleyTable;
    }

    public void setoStrolleyTable(String oStrolleyTable) {
        this.oStrolleyTable = oStrolleyTable;
    }

    public BigDecimal getoSubtotal() {
        return oSubtotal;
    }

    public void setoSubtotal(BigDecimal oSubtotal) {
        this.oSubtotal = oSubtotal;
    }

    public BigDecimal getoServiceCharge() {
        return oServiceCharge;
    }

    public void setoServiceCharge(BigDecimal oServiceCharge) {
        this.oServiceCharge = oServiceCharge;
    }

    public String getoDiscounts() {
        return oDiscounts;
    }

    public void setoDiscounts(String oDiscounts) {
        this.oDiscounts = oDiscounts;
    }

    public BigDecimal getoDiscountsPrice() {
        return oDiscountsPrice;
    }

    public void setoDiscountsPrice(BigDecimal oDiscountsPrice) {
        this.oDiscountsPrice = oDiscountsPrice;
    }

    public String getoDiscountsRemark() {
        return oDiscountsRemark;
    }

    public void setoDiscountsRemark(String oDiscountsRemark) {
        this.oDiscountsRemark = oDiscountsRemark;
    }

    public String getoState() {
        return oState;
    }

    public void setoState(String oState) {
        this.oState = oState;
    }

    public BigDecimal getoTotal() {
        return oTotal;
    }

    public void setoTotal(BigDecimal oTotal) {
        this.oTotal = oTotal;
    }

    public String getoTime() {
        return oTime;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public String getoOvertime() {
		return oOvertime;
	}

	public void setoOvertime(String oOvertime) {
		this.oOvertime = oOvertime;
	}

	public String getOrderToUser() {
        return orderToUser;
    }

    public void setOrderToUser(String orderToUser) {
        this.orderToUser = orderToUser;
    }

    public String getOrderToShop() {
        return orderToShop;
    }

    public void setOrderToShop(String orderToShop) {
        this.orderToShop = orderToShop;
    }

    public String getoShopName() {
        return oShopName;
    }

    public void setoShopName(String oShopName) {
        this.oShopName = oShopName;
    }

    public String getoShopEname() {
        return oShopEname;
    }

    public void setoShopEname(String oShopEname) {
        this.oShopEname = oShopEname;
    }

    

    @Override
    protected Serializable pkVal() {
        return this.oId;
    }

    @Override
	public String toString() {
		return "DbOrder [oId=" + oId + ", oStrolleyTable=" + oStrolleyTable + ", oSubtotal=" + oSubtotal
				+ ", oServiceCharge=" + oServiceCharge + ", oDiscounts=" + oDiscounts + ", oDiscountsPrice="
				+ oDiscountsPrice + ", oDiscountsRemark=" + oDiscountsRemark + ", oState=" + oState + ", oTotal="
				+ oTotal + ", oTime=" + oTime + ", oOvertime=" + oOvertime + ", orderToUser=" + orderToUser
				+ ", orderToShop=" + orderToShop + ", oShopName=" + oShopName + ", oShopEname=" + oShopEname + "]";
	}
}
