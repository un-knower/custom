package com.qingting.customer.model;

import java.util.Calendar;

import com.smart.mvc.model.PersistentObject;

public class MicroFormula extends PersistentObject{
	
	private static final long serialVersionUID = -8811889577713602087L;
	private Integer id;
	private String name;
	private String formula;
	private Float limit;
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
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public Float getLimit() {
		return limit;
	}
	public void setLimit(Float limit) {
		this.limit = limit;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "MicroFormula [id=" + id + ", name=" + name + ", formula=" + formula + ", limit=" + limit
				+ ", createTime=" + createTime + "]";
	}
	
}
