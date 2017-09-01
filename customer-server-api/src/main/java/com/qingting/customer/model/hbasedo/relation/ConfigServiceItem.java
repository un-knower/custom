package com.qingting.customer.model.hbasedo.relation;

import java.util.Calendar;


public class ConfigServiceItem {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 配置ID外键
	 */
	private Integer configId;
	/**
	 * 服务项ID外键
	 */
	private Integer serviceItemId;
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
	public Integer getConfigId() {
		return configId;
	}
	public void setConfigId(Integer configId) {
		this.configId = configId;
	}
	public Integer getServiceItemId() {
		return serviceItemId;
	}
	public void setServiceItemId(Integer serviceItemId) {
		this.serviceItemId = serviceItemId;
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
