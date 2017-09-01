package com.qingting.customer.model.hbasedo.relation;

import java.util.Calendar;


public class ServiceItemItemContext {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 项目ID
	 */
	private Integer projectId;
	/**
	 * 设备ID
	 */
	private Integer equipId;
	/**
	 * 服务项ID
	 */
	private Integer serviceItemId;
	
	/**
	 * 服务内容ID
	 */
	private Integer itemContextId;
	/**
	 * 上次服务时间
	 */
	private Calendar lastTime;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getEquipId() {
		return equipId;
	}
	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}
	public Integer getServiceItemId() {
		return serviceItemId;
	}
	public void setServiceItemId(Integer serviceItemId) {
		this.serviceItemId = serviceItemId;
	}
	public Integer getItemContextId() {
		return itemContextId;
	}
	public void setItemContextId(Integer itemContextId) {
		this.itemContextId = itemContextId;
	}
	public Calendar getLastTime() {
		return lastTime;
	}
	public void setLastTime(Calendar lastTime) {
		this.lastTime = lastTime;
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
