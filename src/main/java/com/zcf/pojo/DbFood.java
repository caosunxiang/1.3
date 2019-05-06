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
public class DbFood extends Model<DbFood> {

    private static final long serialVersionUID = 1L;

    /**
     * 食品id
     */
    @TableId(value = "f_id", type = IdType.AUTO)
    private String fId;
    /**
     * 食品名称
     */
    private String fName;
    /**
     * 食品英文名
     */
    private String fEnglishName;
    /**
     * 食品价格
     */
    private BigDecimal fPrice;
    /**
     * 食品状态
     */
    private String fState;
    /**
     * 食品图片
     */
    private String fPicture;
    /**
     * 食品种类
     */
    private String fType;
    /**
     * 食品种类名称
     */
    private String fTypeName;
    /**
     * 归属店铺
     */
    private String foodToShop;
    /**
     * 月销售额
     * */
    private Integer fMonth;
    /**
     * 伙記推薦
     * */
    private  Integer fRecommend;


    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfEnglishName() {
        return fEnglishName;
    }

    public void setfEnglishName(String fEnglishName) {
        this.fEnglishName = fEnglishName;
    }

    public BigDecimal getfPrice() {
        return fPrice;
    }

    public void setfPrice(BigDecimal fPrice) {
        this.fPrice = fPrice;
    }

    public String getfState() {
        return fState;
    }

    public void setfState(String fState) {
        this.fState = fState;
    }

    public String getfPicture() {
        return fPicture;
    }

    public void setfPicture(String fPicture) {
        this.fPicture = fPicture;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public String getfTypeName() {
        return fTypeName;
    }

    public void setfTypeName(String fTypeName) {
        this.fTypeName = fTypeName;
    }

    public String getFoodToShop() {
        return foodToShop;
    }

    public void setFoodToShop(String foodToShop) {
        this.foodToShop = foodToShop;
    }

    public Integer getfMonth() {
		return fMonth;
	}

	public void setfMonth(Integer fMonth) {
		this.fMonth = fMonth;
	}

	public Integer getfRecommend() {
		return fRecommend;
	}

	public void setfRecommend(Integer fRecommend) {
		this.fRecommend = fRecommend;
	}

	@Override
    protected Serializable pkVal() {
        return this.fId;
    }

    @Override
    public String toString() {
        return "DbFood{" +
        "fId=" + fId +
        ", fName=" + fName +
        ", fEnglishName=" + fEnglishName +
        ", fPrice=" + fPrice +
        ", fState=" + fState +
        ", fPicture=" + fPicture +
        ", fType=" + fType +
        ", fTypeName=" + fTypeName +
        ", foodToShop=" + foodToShop +
        "}";
    }
}
