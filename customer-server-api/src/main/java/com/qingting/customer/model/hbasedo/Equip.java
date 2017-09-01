package com.qingting.customer.model.hbasedo;

import java.util.Calendar;

import com.qingting.customer.model.common.PersistentObject;

public class Equip extends PersistentObject{

	private static final long serialVersionUID = 6288088246557224452L;
	
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 设备编号
	 */
	private String equipCode;
	/**
	 * 物联网卡号
	 */
	private String cardNumber;
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
	private Boolean isOpen;
	/**
	 * 设备是否置顶
	 */
	private Boolean isTop;
	/**
	 * 设备分类ID
	 */
	private Integer equipSortId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 滤芯组合ID
	 */
	private Integer filterGroupId;
	/**
	 * 自来水公司ID
	 */
	private Integer waterAreaId;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	
	
	
	
	public Equip() {
		super();
	}
	
	public Equip(String equipCode) {
		super();
		this.equipCode = equipCode;
	}
	
	public Equip(String equipCode,String cardNumber) {
		super();
		this.equipCode = equipCode;
		this.cardNumber=cardNumber;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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

	public Integer getEquipSortId() {
		return equipSortId;
	}

	public void setEquipSortId(Integer equipSortId) {
		this.equipSortId = equipSortId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFilterGroupId() {
		return filterGroupId;
	}

	public void setFilterGroupId(Integer filterGroupId) {
		this.filterGroupId = filterGroupId;
	}

	public Integer getWaterAreaId() {
		return waterAreaId;
	}

	public void setWaterAreaId(Integer waterAreaId) {
		this.waterAreaId = waterAreaId;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Equip [id=" + id + ", equipCode=" + equipCode + ", cardNumber=" + cardNumber + ", equipMark="
				+ equipMark + ", provinceCode=" + provinceCode + ", cityCode=" + cityCode + ", areaCode=" + areaCode
				+ ", address=" + address + ", isOpen=" + isOpen + ", isTop=" + isTop + ", equipSortId=" + equipSortId
				+ ", userId=" + userId + ", filterGroupId=" + filterGroupId + ", waterAreaId=" + waterAreaId
				+ ", createTime=" + createTime + "]";
	}

	
	
	
}
