package com.qingting.customer.model.dto;


public class EquipDTO {
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 分类名称
	 */
	private String sortName;
	/**
	 * 备注
	 */
	private String equipMark;
	/**
	 * 净水TDS值
	 */
	private Float purTds;
	/**
	 * 监测次数
	 */
	private Long monitorCount;
	/**
	 * 服务次数
	 */
	private Integer serviceCount;
	/**
	 * 剩余时间
	 */
	private Long remainTime;
	/**
	 * 设备地址
	 */
	private String address;
	/**
	 * 设备是否开放
	 */
	private Boolean isOpen;
	/**
	 * 是否开放
	 */
	private Boolean isTop;
	/**
	 * 设备编号
	 */
	private String equipCode;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getEquipMark() {
		return equipMark;
	}
	public void setEquipMark(String equipMark) {
		this.equipMark = equipMark;
	}
	public Float getPurTds() {
		return purTds;
	}
	public void setPurTds(Float purTds) {
		this.purTds = purTds;
	}
	public Long getMonitorCount() {
		return monitorCount;
	}
	public void setMonitorCount(Long monitorCount) {
		this.monitorCount = monitorCount;
	}
	public Integer getServiceCount() {
		return serviceCount;
	}
	public void setServiceCount(Integer serviceCount) {
		this.serviceCount = serviceCount;
	}
	public Long getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(Long remainTime) {
		this.remainTime = remainTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
	public Boolean getIsTop() {
		return isTop;
	}
	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}
	public String getEquipCode() {
		return equipCode;
	}
	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	
	
}
