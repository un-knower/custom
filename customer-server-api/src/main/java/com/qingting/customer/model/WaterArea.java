package com.qingting.customer.model;

import java.util.Calendar;

import com.smart.mvc.model.PersistentObject;

public class WaterArea extends PersistentObject{

	private static final long serialVersionUID = -2093929142840547482L;
	/**
	 * Id 
	 */
	private Integer id;
	/**
	 * 自来水公司名字
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
}
