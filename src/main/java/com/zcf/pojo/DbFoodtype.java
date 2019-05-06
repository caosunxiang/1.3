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
 * @since 2019-04-22
 */
public class DbFoodtype extends Model<DbFoodtype> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜品类型分类id
     */
    @TableId(value = "ft_id", type = IdType.AUTO)
    private Integer ftId;
    /**
     * 菜品类型名称
     */
    private String ftName;
    /**
     * 商铺菜品分类
     */
    private String foodtypeToShop;


    public Integer getFtId() {
        return ftId;
    }

    public void setFtId(Integer ftId) {
        this.ftId = ftId;
    }

    public String getFtName() {
        return ftName;
    }

    public void setFtName(String ftName) {
        this.ftName = ftName;
    }

    public String getFoodtypeToShop() {
        return foodtypeToShop;
    }

    public void setFoodtypeToShop(String foodtypeToShop) {
        this.foodtypeToShop = foodtypeToShop;
    }

    @Override
    protected Serializable pkVal() {
        return this.ftId;
    }

    @Override
    public String toString() {
        return "DbFoodtype{" +
        "ftId=" + ftId +
        ", ftName=" + ftName +
        ", foodtypeToShop=" + foodtypeToShop +
        "}";
    }
}
