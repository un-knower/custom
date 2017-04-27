package com.qingting.customer.common.pojo.hbasedo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Equip {
	
	/**
	 * 设备名称
	 */
	private String equipName;
	/**
	 * 设备地址
	 */
	private String equipAddr;
	/**
	 * 设备是否开放
	 */
	private Boolean open;
	/**
	 * 设备分类ID
	 */
	private Integer equipSortId;
	/**
	 * 项目ID
	 */
	private Integer projectId;
	/**
	 * 数据的版本
	 */
	private final Byte version = 0;
	
	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getEquipAddr() {
		return equipAddr;
	}

	public void setEquipAddr(String equipAddr) {
		this.equipAddr = equipAddr;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Integer getEquipSortId() {
		return equipSortId;
	}

	public void setEquipSortId(Integer equipSortId) {
		this.equipSortId = equipSortId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public Byte getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
