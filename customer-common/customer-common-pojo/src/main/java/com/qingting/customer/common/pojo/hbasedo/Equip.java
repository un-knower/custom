package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.hadoop.hbase.util.Bytes;

public class Equip {
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
	 * 设备名称
	 */
	private String equipName;
	/**
	 * 备注
	 */
	private String equipMark;
	/**
	 * 省外键
	 */
	private Integer provinceId;
	/**
	 * 市外键
	 */
	private Integer cityId;
	/**
	 * 区外键
	 */
	private Integer areaId;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 经度
	 */
	private Float lng;
	/**
	 * 纬度
	 */
	private Float lat;
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

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getEquipMark() {
		return equipMark;
	}

	public void setEquipMark(String equipMark) {
		this.equipMark = equipMark;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	/**
	 * 
	 * @Title: setContentOfRowKey
	 * @Description: 根据查询的rowkey设置对应rowkey中包含的字段
	 * @param rowkey
	 * @return void
	 * @throws
	 */
	public void setContentOfRowKey(byte[] rowkey){
		this.rowKey=new String(rowkey);
		if(rowkey.length<8){
			throw new RuntimeException(this.getClass()+"rowkey长度有误，请检查程序.");
		}
		byte[] dest=new byte[4];
		System.arraycopy(rowkey, 0, dest, 0, 4);//前4个字节,所属项目id
		this.projectId=Bytes.toInt(dest);
		System.arraycopy(rowkey, rowkey.length-4, dest, 0, 4);//最后4个字节,设备id
		this.id=Bytes.toInt(dest);
	}
}
