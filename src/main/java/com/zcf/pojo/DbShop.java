package com.zcf.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
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
public class DbShop extends Model<DbShop> {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺id
     */
    @TableId(value = "s_id", type = IdType.NONE)
    private String sId;
    /**
     * 中文店名
     */
    private String sName;
    /**
     * 英文店名
     */
    private String sEnglishName;
    /**
     * 主营类型
     */
    private String sBusinessType;
    /**
     * 商铺类型
     */
    private String sType;
    /**
     * 商铺类型名称
     */
    private String sTypeName;
    /**
     * 店铺图片
     */
    private String sPicture;
    /**
     * 商铺状态
     */
    private String sState;
    /**
     * 商户唯一验证
     */
    private Integer sVerify;
    /**
     * 商铺分数
     */
    private Integer sScore;
    /**
     * 商铺电话
     * */
    private String sPhone;
    /**
     * 商铺开门时间
     */
    private String sOpenTime;
    /**
     * 店铺关门时间
     */
    private String sCloseTime;
    /**
     * 商铺经度
     */
    private String sLongitude;
    /**
     * 商铺纬度
     */
    private String sLatitude;
    /**
     * 商铺热门
     */
    private String sHot;
    /**
     * 平均消费
     */
    private BigDecimal sAverage;
    /**
     * 具体位置
     * */
    private String sArea;
    /**
     * 电子邮箱
     * */
    private String sEmail;
    /**
     * 描述
     * */
    private String sRemark;
    /**
     * 是否可以停車
     * */
    private String sPark;
    /**
     * 是否浪漫
     * */
    private String sRomance;
    /**
     * 註冊時間
     * */
    private String sTime;
    /**
     * 距離
     * */
    @TableField(exist =false)
    private Double distance;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEnglishName() {
        return sEnglishName;
    }

    public void setsEnglishName(String sEnglishName) {
        this.sEnglishName = sEnglishName;
    }

    public String getsBusinessType() {
        return sBusinessType;
    }

    public void setsBusinessType(String sBusinessType) {
        this.sBusinessType = sBusinessType;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getsTypeName() {
        return sTypeName;
    }

    public void setsTypeName(String sTypeName) {
        this.sTypeName = sTypeName;
    }

    public String getsPicture() {
        return sPicture;
    }

    public void setsPicture(String sPicture) {
        this.sPicture = sPicture;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public Integer getsVerify() {
        return sVerify;
    }

    public void setsVerify(Integer sVerify) {
        this.sVerify = sVerify;
    }

    public Integer getsScore() {
        return sScore;
    }

    public void setsScore(Integer sScore) {
        this.sScore = sScore;
    }

    public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsOpenTime() {
        return sOpenTime;
    }

    public void setsOpenTime(String sOpenTime) {
        this.sOpenTime = sOpenTime;
    }

    public String getsCloseTime() {
        return sCloseTime;
    }

    public void setsCloseTime(String sCloseTime) {
        this.sCloseTime = sCloseTime;
    }

    public String getsLongitude() {
        return sLongitude;
    }

    public void setsLongitude(String sLongitude) {
        this.sLongitude = sLongitude;
    }

  

    public String getsLatitude() {
		return sLatitude;
	}

	public void setsLatitude(String sLatitude) {
		this.sLatitude = sLatitude;
	}

	public String getsHot() {
        return sHot;
    }

    public void setsHot(String sHot) {
        this.sHot = sHot;
    }

    public BigDecimal getsAverage() {
        return sAverage;
    }

    public void setsAverage(BigDecimal sAverage) {
        this.sAverage = sAverage;
    }

    public String getsArea() {
		return sArea;
	}

	public void setsArea(String sArea) {
		this.sArea = sArea;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsRemark() {
		return sRemark;
	}

	public void setsRemark(String sRemark) {
		this.sRemark = sRemark;
	}

	public String getsPark() {
		return sPark;
	}

	public void setsPark(String sPark) {
		this.sPark = sPark;
	}

	public String getsRomance() {
		return sRomance;
	}

	public void setsRomance(String sRomance) {
		this.sRomance = sRomance;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
    protected Serializable pkVal() {
        return this.sId;
    }

    @Override
	public String toString() {
		return "DbShop [sId=" + sId + ", sName=" + sName + ", sEnglishName=" + sEnglishName + ", sBusinessType="
				+ sBusinessType + ", sType=" + sType + ", sTypeName=" + sTypeName + ", sPicture=" + sPicture
				+ ", sState=" + sState + ", sVerify=" + sVerify + ", sScore=" + sScore + ", sPhone=" + sPhone
				+ ", sOpenTime=" + sOpenTime + ", sCloseTime=" + sCloseTime + ", sLongitude=" + sLongitude
				+ ", sLatitude=" + sLatitude + ", sHot=" + sHot + ", sAverage=" + sAverage + "]";
	}
}
