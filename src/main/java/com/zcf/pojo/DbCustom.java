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
public class DbCustom extends Model<DbCustom> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品自定栏id
     */
    @TableId(value = "c_id", type = IdType.NONE)
    private String cId;
    /**
     * 商品自定名称
     */
    private String cName;
    /**
     * 商品自定英文名
     */
    private String cEnglishName;
    /**
     * 菜品自定选项状态
     */
    private String cState;
    /**
     * 商铺自定
     * */
    private String shopCustom;


    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcEnglishName() {
        return cEnglishName;
    }

    public void setcEnglishName(String cEnglishName) {
        this.cEnglishName = cEnglishName;
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState;
    }

    public String getShopCustom() {
		return shopCustom;
	}

	public void setShopCustom(String shopCustom) {
		this.shopCustom = shopCustom;
	}

	@Override
    protected Serializable pkVal() {
        return this.cId;
    }

    @Override
    public String toString() {
        return "DbCustom{" +
        "cId=" + cId +
        ", cName=" + cName +
        ", cEnglishName=" + cEnglishName +
        ", cState=" + cState +
        "}";
    }
}
