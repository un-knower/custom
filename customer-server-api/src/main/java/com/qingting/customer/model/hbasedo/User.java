package com.qingting.customer.model.hbasedo;

import java.util.Calendar;

import com.alibaba.fastjson.annotation.JSONField;
import com.qingting.customer.model.common.PersistentObject;

import io.swagger.annotations.ApiModelProperty;

public class User extends PersistentObject{
	
	private static final long serialVersionUID = 6610579266435676798L;
	
	private String rowkey;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 登录账号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String name;
	/** 
	 * 性别 
	 */
	private Boolean sex;
	/** 
	 * 年龄
	 */
	private Integer age;
	/**
	 * 省编码
	 */
	private String provinceCode;
	/**
	 * 市编码
	 */
	private String cityCode;
	/**
	 * 区编码
	 */
	private String areaCode;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 用户分类id
	 */
	private Integer userSortId;
	/**
	 * 头像URL
	 */
	private String portraitUrl;
	/**
	 * 账号状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="时间",example="2017-01-01 12:00:00",dataType="String")
	private Calendar createTime;
	
	
	public String getRowkey() {
		return rowkey;
	}
	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public String getPortraitUrl() {
		return portraitUrl;
	}
	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserSortId() {
		return userSortId;
	}
	public void setUserSortId(Integer userSortId) {
		this.userSortId = userSortId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", mobile=" + mobile + ", name=" + name + ", sex=" + sex + ", age=" + age
				+ ", provinceCode=" + provinceCode + ", cityCode=" + cityCode + ", areaCode=" + areaCode + ", address="
				+ address + ", userSortId=" + userSortId + ", portraitUrl=" + portraitUrl + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}
	
}
