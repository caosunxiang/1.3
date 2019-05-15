package com.zcf.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class DbAdmin extends Model<DbAdmin> {
	
	 private static final long serialVersionUID = 1L;
	 
	 @TableId(value = "a_id", type = IdType.AUTO)
	 
	 private String aId;
	 
	 private String aName;
	 
	 private String aPwd;
	 
	 
	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPwd() {
		return aPwd;
	}

	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}

	@Override
	public String toString() {
		return "DbAdmin [aId=" + aId + ", aName=" + aName + ", aPwd=" + aPwd + "]";
	}

	@Override
	protected Serializable pkVal() {
		return this.aId;
	}

}
