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
 * @since 2019-04-25
 */
public class DbOutline extends Model<DbOutline> {

    private static final long serialVersionUID = 1L;

    /**
     * 大纲id
     */
    @TableId(value = "l_id", type = IdType.NONE)
    private String lId;
    /**
     * 大纲内容
     */
    private String lContent;
    /**
     * 大纲选取次数
     */
    private Integer lNum;


    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }

    public String getlContent() {
        return lContent;
    }

    public void setlContent(String lContent) {
        this.lContent = lContent;
    }

    public Integer getlNum() {
        return lNum;
    }

    public void setlNum(Integer lNum) {
        this.lNum = lNum;
    }

    @Override
    protected Serializable pkVal() {
        return this.lId;
    }

    @Override
    public String toString() {
        return "DbOutline{" +
        "lId=" + lId +
        ", lContent=" + lContent +
        ", lNum=" + lNum +
        "}";
    }
}
