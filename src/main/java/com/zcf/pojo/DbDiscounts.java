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
public class DbDiscounts extends Model<DbDiscounts> {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠劵id
     */
    @TableId(value = "d_id", type = IdType.NONE)
    private String dId;
    /**
     * 优惠券价格
     */
    private BigDecimal dPrice;
    /**
     * 店鋪標題
     * */
    private String dTitle;
    /**
     * 优惠券描述
     */
    private String dRemark;
    /**
     * 优惠券开始时间
     */
    private String dStarttime;
    /**
     * 优惠券完结时间
     */
    private String dOvertime;
    /**
     * 优惠券限制
     */
    private BigDecimal dRestrict;
    /**
     * 最多领取个数
     * */
    private Integer dMaximum;
    /**
     * 商铺id
     */
    private String discountsToShop;
    /**
     * 店铺名称
     */
    private String dsName;
    /**
     * 商铺英文名
     */
    private String dsEname;
   
     


    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public BigDecimal getdPrice() {
        return dPrice;
    }

    public void setdPrice(BigDecimal dPrice) {
        this.dPrice = dPrice;
    }

    public String getdTitle() {
		return dTitle;
	}

	public void setdTitle(String dTitle) {
		this.dTitle = dTitle;
	}

	public String getdRemark() {
        return dRemark;
    }

    public void setdRemark(String dRemark) {
        this.dRemark = dRemark;
    }

    public String getdStarttime() {
        return dStarttime;
    }

    public void setdStarttime(String dStarttime) {
        this.dStarttime = dStarttime;
    }

    public String getdOvertime() {
        return dOvertime;
    }

    public void setdOvertime(String dOvertime) {
        this.dOvertime = dOvertime;
    }

    public BigDecimal getdRestrict() {
        return dRestrict;
    }

    public void setdRestrict(BigDecimal dRestrict) {
        this.dRestrict = dRestrict;
    }

    public Integer getdMaximum() {
		return dMaximum;
	}

	public void setdMaximum(Integer dMaximum) {
		this.dMaximum = dMaximum;
	}

	public String getDiscountsToShop() {
        return discountsToShop;
    }

    public void setDiscountsToShop(String discountsToShop) {
        this.discountsToShop = discountsToShop;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getDsEname() {
        return dsEname;
    }

    public void setDsEname(String dsEname) {
        this.dsEname = dsEname;
    }

    @Override
    protected Serializable pkVal() {
        return this.dId;
    }

    @Override
    public String toString() {
        return "DbDiscounts{" +
        "dId=" + dId +
        ", dPrice=" + dPrice +
        ", dRemark=" + dRemark +
        ", dStarttime=" + dStarttime +
        ", dOvertime=" + dOvertime +
        ", dRestrict=" + dRestrict +
        ", discountsToShop=" + discountsToShop +
        ", dsName=" + dsName +
        ", dsEname=" + dsEname +
        "}";
    }
}
