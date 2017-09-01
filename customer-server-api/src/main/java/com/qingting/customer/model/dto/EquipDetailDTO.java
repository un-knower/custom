package com.qingting.customer.model.dto;

public class EquipDetailDTO {
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 经度
	 */
	private Float lng;
	/**
	 * 纬度
	 */
	private Float lat;
	/**
	 * 预警标志
	 */
	private boolean warnFlag;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getLng() {
		return lng;
	}
	public void setLng(Float lng) {
		this.lng = lng;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public boolean isWarnFlag() {
		return warnFlag;
	}
	public void setWarnFlag(boolean warnFlag) {
		this.warnFlag = warnFlag;
	}
	
}
