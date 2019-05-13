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
public class DbUser extends Model<DbUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "open_id", type = IdType.NONE)
    private String openId;
    /**
     * 微信名称
     */
    private String uName;
    /**
     * 微信头像
     */
    private String uHead;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 微信地址
     */
    private String uArea;
    /**
     *  用户经度
     * */
    private String u_longitude;
    /**
     *  用户纬度
     * */
    private String u_latitude;


    public String getU_longitude() {
		return u_longitude;
	}

	public void setU_longitude(String u_longitude) {
		this.u_longitude = u_longitude;
	}

	public String getU_latitude() {
		return u_latitude;
	}

	public void setU_latitude(String u_latitude) {
		this.u_latitude = u_latitude;
	}

	public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuHead() {
        return uHead;
    }

    public void setuHead(String uHead) {
        this.uHead = uHead;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getuArea() {
        return uArea;
    }

    public void setuArea(String uArea) {
        this.uArea = uArea;
    }

    @Override
    protected Serializable pkVal() {
        return this.openId;
    }

    @Override
    public String toString() {
        return "DbUser{" +
        "openId=" + openId +
        ", uName=" + uName +
        ", uHead=" + uHead +
        ", parentId=" + parentId +
        ", uArea=" + uArea +
        "}";
    }
}
