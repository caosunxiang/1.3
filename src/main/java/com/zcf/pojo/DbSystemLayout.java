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
 * @author zhouzhuang
 * @since 2019-05-16
 */
public class DbSystemLayout extends Model<DbSystemLayout> {

    private static final long serialVersionUID = 1L;

    /**
     * 系统配置id
     */
    @TableId(value = "slid", type = IdType.AUTO)
    private Integer slid;
    /**
     * 系统配置名字
     */
    private String slname;
    /**
     * 内容
     */
    private String slcontent;


    public Integer getSlid() {
        return slid;
    }

    public void setSlid(Integer slid) {
        this.slid = slid;
    }

    public String getSlname() {
        return slname;
    }

    public void setSlname(String slname) {
        this.slname = slname;
    }

    public String getSlcontent() {
        return slcontent;
    }

    public void setSlcontent(String slcontent) {
        this.slcontent = slcontent;
    }

    @Override
    protected Serializable pkVal() {
        return this.slid;
    }

    @Override
    public String toString() {
        return "DbSystemLayout{" +
        "slid=" + slid +
        ", slname=" + slname +
        ", slcontent=" + slcontent +
        "}";
    }
}
