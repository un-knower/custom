package com.qingting.customer.common.pojo.hbasedo.relation;

import java.util.Calendar;

public class Stick {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 用户Id
	 */
	private Integer userId;
	/**
	 * 设备Id
	 */
	private Integer equipId;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	/**
	 * 数据的版本
	 */
	private final Byte version = 0;
	
	public Stick(Integer equipId) {
		super();
		this.equipId = equipId;
	}
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getEquipId() {
		return equipId;
	}
	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
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
