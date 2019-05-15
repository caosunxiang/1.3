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
public class DbSet extends Model<DbSet> {

    private static final long serialVersionUID = 1L;

    /**
     * 套配id
     */
    @TableId(value = "set_id", type = IdType.NONE)
    private String setId;
    /**
     * 套配名称
     */
    private String setName;
    /**
     * 套配英文名称
     */
    private String setEnglishName;
    /**
     * 套配状态
     */
    private String setState;
    /**
     * 商铺配套
     * */
    private String setShop;


    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetEnglishName() {
        return setEnglishName;
    }

    public void setSetEnglishName(String setEnglishName) {
        this.setEnglishName = setEnglishName;
    }

    public String getSetState() {
        return setState;
    }

    public void setSetState(String setState) {
        this.setState = setState;
    }

    public String getSetShop() {
		return setShop;
	}

	public void setSetShop(String setShop) {
		this.setShop = setShop;
	}

	@Override
    protected Serializable pkVal() {
        return this.setId;
    }

    @Override
    public String toString() {
        return "DbSet{" +
        "setId=" + setId +
        ", setName=" + setName +
        ", setEnglishName=" + setEnglishName +
        ", setState=" + setState +
        "}";
    }
}
