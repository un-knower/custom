package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import com.qingting.customer.common.pojo.common.PersistentObject;

public class FilterGroup extends PersistentObject{
	
	private static final long serialVersionUID = -3707091356670337549L;
	
	private Integer id;
	/**
	 * 第一级滤芯ID外键
	 */
	private Integer oneFilterId;
	/**
	 * 第二级滤芯ID外键
	 */
	private Integer twoFilterId;
	/**
	 * 第三级滤芯ID外键
	 */
	private Integer threeFilterId;
	/**
	 * 第四级滤芯ID外键
	 */
	private Integer fourFilterId;
	/**
	 * 第五级滤芯ID外键
	 */
	private Integer fiveFilterId;
	/**
	 * 微生物模型外键
	 */
	private Integer microId;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOneFilterId() {
		return oneFilterId;
	}
	public void setOneFilterId(Integer oneFilterId) {
		this.oneFilterId = oneFilterId;
	}
	public Integer getTwoFilterId() {
		return twoFilterId;
	}
	public void setTwoFilterId(Integer twoFilterId) {
		this.twoFilterId = twoFilterId;
	}
	public Integer getThreeFilterId() {
		return threeFilterId;
	}
	public void setThreeFilterId(Integer threeFilterId) {
		this.threeFilterId = threeFilterId;
	}
	public Integer getFourFilterId() {
		return fourFilterId;
	}
	public void setFourFilterId(Integer fourFilterId) {
		this.fourFilterId = fourFilterId;
	}
	public Integer getFiveFilterId() {
		return fiveFilterId;
	}
	public void setFiveFilterId(Integer fiveFilterId) {
		this.fiveFilterId = fiveFilterId;
	}
	public Integer getMicroId() {
		return microId;
	}
	public void setMicroId(Integer microId) {
		this.microId = microId;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "FilterGroup [id=" + id + ", oneFilterId=" + oneFilterId + ", twoFilterId=" + twoFilterId
				+ ", threeFilterId=" + threeFilterId + ", fourFilterId=" + fourFilterId + ", fiveFilterId="
				+ fiveFilterId + ", microId=" + microId + ", createTime=" + createTime + "]";
	}
	
}
