package com.qingting.customer.model.hbasedo.relation;

import java.util.Calendar;

public class ServiceOtherContext {
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
	 * 其他服务内容ID
	 */
	private Integer otherContextId;
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
	public Integer getOtherContextId() {
		return otherContextId;
	}
	public void setOtherContextId(Integer otherContextId) {
		this.otherContextId = otherContextId;
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
