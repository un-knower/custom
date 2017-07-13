package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import com.qingting.customer.common.pojo.common.PersistentObject;

public class EquipSort extends PersistentObject{
	
	private static final long serialVersionUID = 858079665799249763L;
	
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 分类名称
	 */
	private String sortName;
	/**
	 * 图像路径
	 */
	private String imageUrl;
	/**
	 * 创建者ID
	 */
	private Integer userId;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	/**
	 * 数据的版本
	 */
	private final Byte version = 0;
	
	public String getRowKey() {
		return rowKey;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	public Byte getVersion() {
		return version;
	}
	
	
}
