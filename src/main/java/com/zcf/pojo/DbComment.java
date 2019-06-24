package com.zcf.pojo;

import java.util.Date;
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
public class DbComment extends Model<DbComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "c_id", type = IdType.NONE)
    private String cId;
    /**
     * 评论内容
     */
    private String cContent;
    /**
     * 评论分数
     */
    private Integer cScore;
    /**
     * 评论回复
     */
    private String cReply;
    /**
     * 评论置顶
     * */
    private String cUp;
    /**
     * 评论时间
     */
    private String cTime;
    /**
     * 评论关联订单
     */
    private String commentToOrder;
    /**
     * 评论订单桌号
     */
    private String cOrderTable;
    /**
     * 评论订单时间
     */
    private String cOrderTime;
    /**
     * 评价关联用户
     */
    private String commentToUser;
    /**
     * 评论关联名称
     * */
    private String cUserName;
    /**
     * 评价用户头像
     */
    private String cUserHead;
    /**
     * 评论关联店铺
     */
    private String commentToShop;
    /**
     * 评论商铺名称
     */
    private String cShopName;
    /**
     * 评论商铺英文名
     */
    private String cShopEname;
    /**
     * 評論大綱
     * */
    private String commentToLine;
    /**
     * 評論內容
     * */
    private String cLineContent;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public Integer getcScore() {
        return cScore;
    }

    public void setcScore(Integer cScore) {
        this.cScore = cScore;
    }

   

    public String getcReply() {
		return cReply;
	}

	public void setcReply(String cReply) {
		this.cReply = cReply;
	}

	public String getcUp() {
		return cUp;
	}

	public void setcUp(String cUp) {
		this.cUp = cUp;
	}

	public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getCommentToOrder() {
        return commentToOrder;
    }

    public void setCommentToOrder(String commentToOrder) {
        this.commentToOrder = commentToOrder;
    }

    public String getcOrderTable() {
        return cOrderTable;
    }

    public void setcOrderTable(String cOrderTable) {
        this.cOrderTable = cOrderTable;
    }

    public String getcOrderTime() {
        return cOrderTime;
    }

    public void setcOrderTime(String cOrderTime) {
        this.cOrderTime = cOrderTime;
    }

    public String getCommentToUser() {
        return commentToUser;
    }

    public void setCommentToUser(String commentToUser) {
        this.commentToUser = commentToUser;
    }

    public String getcUserName() {
		return cUserName;
	}

	public void setcUserName(String cUserName) {
		this.cUserName = cUserName;
	}

	public String getcUserHead() {
        return cUserHead;
    }

    public void setcUserHead(String cUserHead) {
        this.cUserHead = cUserHead;
    }

    public String getCommentToShop() {
        return commentToShop;
    }

    public void setCommentToShop(String commentToShop) {
        this.commentToShop = commentToShop;
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName;
    }

    public String getcShopEname() {
        return cShopEname;
    }

    public void setcShopEname(String cShopEname) {
        this.cShopEname = cShopEname;
    }

    @Override
    protected Serializable pkVal() {
        return this.cId;
    }

    public String getCommentToLine() {
		return commentToLine;
	}

	public void setCommentToLine(String commentToLine) {
		this.commentToLine = commentToLine;
	}

	public String getcLineContent() {
		return cLineContent;
	}

	public void setcLineContent(String cLineContent) {
		this.cLineContent = cLineContent;
	}

	@Override
    public String toString() {
        return "DbComment{" +
        "cId=" + cId +
        ", cContent=" + cContent +
        ", cScore=" + cScore +
        ", creply=" + cReply +
        ", cTime=" + cTime +
        ", commentToOrder=" + commentToOrder +
        ", cOrderTable=" + cOrderTable +
        ", cOrderTime=" + cOrderTime +
        ", commentToUser=" + commentToUser +
        ", cUserHead=" + cUserHead +
        ", commentToShop=" + commentToShop +
        ", cShopName=" + cShopName +
        ", cShopEname=" + cShopEname +
        "}";
    }
}
