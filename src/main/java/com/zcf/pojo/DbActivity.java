package com.zcf.pojo;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
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
 * @since 2019-04-26
 */
public class DbActivity extends Model<DbActivity> {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;
    /**
     * 活动标题
     */
    private String aTitle;
    /**
     * 食物描述
     */
    private String aFcontent;
    /**
     * 活动描述
     */
    private String aContent;
    /**
     * 活动图片
     */
    private String aHead;
    /**
     * 活动商家
     */
    private String activityToShop;
    /**
     * 活动优惠券
     */
    private String activityToDiscounts;


    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaFcontent() {
        return aFcontent;
    }

    public void setaFcontent(String aFcontent) {
        this.aFcontent = aFcontent;
    }

    public String getaContent() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent = aContent;
    }

    public String getaHead() {
        return aHead;
    }

    public void setaHead(String aHead) {
        this.aHead = aHead;
    }

    public String getActivityToShop() {
        return activityToShop;
    }

    public void setActivityToShop(String activityToShop) {
        this.activityToShop = activityToShop;
    }

    public String getActivityToDiscounts() {
        return activityToDiscounts;
    }

    public void setActivityToDiscounts(String activityToDiscounts) {
        this.activityToDiscounts = activityToDiscounts;
    }

    @Override
    protected Serializable pkVal() {
        return this.aId;
    }

    @Override
    public String toString() {
        return "DbActivity{" +
        "aId=" + aId +
        ", aTitle=" + aTitle +
        ", aFcontent=" + aFcontent +
        ", aContent=" + aContent +
        ", aHead=" + aHead +
        ", activityToShop=" + activityToShop +
        ", activityToDiscounts=" + activityToDiscounts +
        "}";
    }
}
