package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.hadoop.hbase.util.Bytes;

public class Project {
	/**
	 * rowkey
	 */
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 项目编号
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 备注
	 */
	private String projectMark;
	/**
	 * 设备数量
	 */
	private Integer equipCount;
	/**
	 * 开始时间
	 */
	private Calendar startTime;
	/**
	 * 到期时间
	 */
	private Calendar endTime;
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
	 * 项目分类ID
	 */
	private Integer projectSortId;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 套餐ID
	 */
	private Integer comboId;
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

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectMark() {
		return projectMark;
	}

	public void setProjectMark(String projectMark) {
		this.projectMark = projectMark;
	}

	public Integer getEquipCount() {
		return equipCount;
	}

	public void setEquipCount(Integer equipCount) {
		this.equipCount = equipCount;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
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

	public Integer getProjectSortId() {
		return projectSortId;
	}

	public void setProjectSortId(Integer projectSortId) {
		this.projectSortId = projectSortId;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getComboId() {
		return comboId;
	}

	public void setComboId(Integer comboId) {
		this.comboId = comboId;
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
		System.arraycopy(rowkey, 0, dest, 0, 4);//前4个字节,所属用户id
		this.userId=Bytes.toInt(dest);
		System.arraycopy(rowkey, 4, dest, 0, 4);//中间4个字节,项目套餐id
		this.comboId=Bytes.toInt(dest);
		System.arraycopy(rowkey, rowkey.length-4, dest, 0, 4);//最后4个字节,项目id
		this.id=Bytes.toInt(dest);
	}
}
