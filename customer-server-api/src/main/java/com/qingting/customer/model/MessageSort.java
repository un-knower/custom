package com.qingting.customer.model;

import java.util.Calendar;

import com.smart.mvc.model.PersistentObject;

public class MessageSort extends PersistentObject{

	private static final long serialVersionUID = -8786472582769247777L;
	
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 分类编号
	 */
	private String sortCode;
	/**
	 * 分类名称
	 */
	private String sortName;
	/**
	 * 创建者ID
	 */
	private Integer userId;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	
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
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
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

	
}
