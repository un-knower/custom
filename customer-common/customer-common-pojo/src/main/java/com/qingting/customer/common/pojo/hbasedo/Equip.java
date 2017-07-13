package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import com.qingting.customer.common.pojo.common.PersistentObject;

public class Equip extends PersistentObject{

	private static final long serialVersionUID = 6288088246557224452L;
	
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 设备编号
	 */
	private String equipCode;
	/**
	 * 备注
	 */
	private String equipMark;
	/**
	 * 省外键
	 */
	private String provinceCode;
	/**
	 * 市外键
	 */
	private String cityCode;
	/**
	 * 区外键
	 */
	private String areaCode;
	/**
	 * 地址
	 */
	private String address;
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
	 * 用户ID
	 */
	private Integer userId;
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
	public String getEquipCode() {
		return equipCode;
	}
	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	public String getEquipMark() {
		return equipMark;
	}
	public void setEquipMark(String equipMark) {
		this.equipMark = equipMark;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
