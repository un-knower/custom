package com.qingting.customer.model.hbasedo;

import java.util.Calendar;

import com.qingting.customer.model.common.PersistentObject;

public class City extends PersistentObject{
	
	private static final long serialVersionUID = 3253194771586334189L;
	/**
	 * ID
	 */
	private int id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 省编码
	 */
	private String provinceCode;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", name=" + name + ", provinceCode=" + provinceCode
				+ ", createTime=" + createTime + "]";
	}
	
}
