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
 * @since 2019-04-29
 */
public class DbFast extends Model<DbFast> {

    private static final long serialVersionUID = 1L;

    /**
     * 快捷搜索id
     */
    @TableId(value = "f_id", type = IdType.AUTO)
    private Integer fId;
    /**
     * 快捷搜索名称
     */
    private String fName;
    /**
     * 快捷点击次数
     */
    private Integer fCount;


    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getfCount() {
        return fCount;
    }

    public void setfCount(Integer fCount) {
        this.fCount = fCount;
    }

    @Override
    protected Serializable pkVal() {
        return this.fId;
    }

    @Override
    public String toString() {
        return "DbFast{" +
        "fId=" + fId +
        ", fName=" + fName +
        ", fCount=" + fCount +
        "}";
    }
}
