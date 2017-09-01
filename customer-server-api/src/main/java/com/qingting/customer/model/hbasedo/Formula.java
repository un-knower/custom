package com.qingting.customer.model.hbasedo;

import java.util.Calendar;


import com.qingting.customer.model.common.PersistentObject;

public class Formula extends PersistentObject{
	
	private static final long serialVersionUID = -6652752765064172937L;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 第几级
	 */
	private Byte order;
	/**
	 * 公式
	 */
	private String formula;
	/**
	 * 滤芯ID
	 */
	private Integer filterId;
	/**
	 * 创建者ID
	 */
	private Integer userId;
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
	public Byte getOrder() {
		return order;
	}
	public void setOrder(Byte order) {
		this.order = order;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public Integer getFilterId() {
		return filterId;
	}
	public void setFilterId(Integer filterId) {
		this.filterId = filterId;
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
