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
 * @since 2019-06-06
 */
public class DbCode extends Model<DbCode> {

    private static final long serialVersionUID = 1L;

    /**
     * 二维码id
     */
    @TableId(value = "c_id", type = IdType.NONE)
    private String cId;
    /**
     * 归属商家
     */
    private String codeToShop;
    /**
     * 桌号
     */
    private Integer table;
    /**
     * 二维码地址
     */
    private String cPic;


    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getCodeToShop() {
        return codeToShop;
    }

    public void setCodeToShop(String codeToShop) {
        this.codeToShop = codeToShop;
    }

    public Integer getTable() {
        return table;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public String getcPic() {
        return cPic;
    }

    public void setcPic(String cPic) {
        this.cPic = cPic;
    }

    @Override
    protected Serializable pkVal() {
        return this.cId;
    }

    @Override
    public String toString() {
        return "DbCode{" +
        "cId=" + cId +
        ", codeToShop=" + codeToShop +
        ", table=" + table +
        ", cPic=" + cPic +
        "}";
    }
}
