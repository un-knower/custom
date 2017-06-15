package com.qingting.customer.common.pojo.hbasedo.relation;

import java.util.Calendar;

public class ServiceItemContext {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 服务ID
	 */
	private Integer serviceId;
	/**
	 * 服务内容ID
	 */
	private Integer itemContextId;
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
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getItemContextId() {
		return itemContextId;
	}
	public void setItemContextId(Integer itemContextId) {
		this.itemContextId = itemContextId;
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
