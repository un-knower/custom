package com.qingting.customer.model.hbasedo.relation;

import java.util.Calendar;


public class ComboExtra {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 套餐ID外键
	 */
	private Integer comboId;
	/**
	 * 配置和特权ID外键
	 */
	private Integer extraId;
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
	public Integer getComboId() {
		return comboId;
	}
	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}
	public Integer getExtraId() {
		return extraId;
	}
	public void setExtraId(Integer extraId) {
		this.extraId = extraId;
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
