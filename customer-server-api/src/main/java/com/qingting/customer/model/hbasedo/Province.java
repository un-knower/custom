package com.qingting.customer.model.hbasedo;

import java.util.Calendar;

import com.qingting.customer.model.common.PersistentObject;

public class Province extends PersistentObject{

	private static final long serialVersionUID = 5697613037100670153L;
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
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", code=" + code + ", name=" + name + ", createTime=" + createTime + "]";
	}
	
}
