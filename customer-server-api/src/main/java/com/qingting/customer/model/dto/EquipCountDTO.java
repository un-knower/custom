package com.qingting.customer.model.dto;
/**
 * 
 * @ClassName: CountryDistDTO
 * @Description: 设备全国分布图数据
 * @author zlf
 * @date 2017年6月17日 下午5:44:24
 *
 */
public class EquipCountDTO {
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 设备数量
	 */
	private Integer equipCount;
	/**
	 * 预警设备数量
	 */
	private Integer warnCount;
	/**
	 * 经度
	 */
	private Float lng;
	/**
	 * 纬度
	 */
	private Float lat;
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
	public Integer getEquipCount() {
		return equipCount;
	}
	public void setEquipCount(Integer equipCount) {
		this.equipCount = equipCount;
	}
	public Integer getWarnCount() {
		return warnCount;
	}
	public void setWarnCount(Integer warnCount) {
		this.warnCount = warnCount;
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
	
}
