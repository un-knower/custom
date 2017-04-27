package com.qingting.customer.common.pojo.hbasedo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Project {
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 设备数量
	 */
	private Integer equipCount;
	/**
	 * 到期时间
	 */
	private Date deadline;
	/**
	 * 项目地址
	 */
	private String projectAddr;
	/**
	 * 项目分类ID
	 */
	private Integer projectSortId;
	/**
	 * 数据的版本
	 */
	private final Byte version = 0;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getEquipCount() {
		return equipCount;
	}

	public void setEquipCount(Integer equipCount) {
		this.equipCount = equipCount;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getProjectAddr() {
		return projectAddr;
	}

	public void setProjectAddr(String projectAddr) {
		this.projectAddr = projectAddr;
	}

	public Integer getProjectSortId() {
		return projectSortId;
	}

	public void setProjectSortId(Integer projectSortId) {
		this.projectSortId = projectSortId;
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
