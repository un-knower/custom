package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import com.qingting.customer.common.pojo.common.PersistentObject;

public class Filter extends PersistentObject{

	private static final long serialVersionUID = 2827740019579919132L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 供应商名字
	 */
	private String supply;
	/**
	 * 滤芯名字
	 */
	private String name;
	/**
	 * 寿命时间
	 */
	private Float lifeTime;
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
	public String getSupply() {
		return supply;
	}
	public void setSupply(String supply) {
		this.supply = supply;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getLifeTime() {
		return lifeTime;
	}
	public void setLifeTime(Float lifeTime) {
		this.lifeTime = lifeTime;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Filter [id=" + id + ", supply=" + supply + ", name=" + name + ", lifeTime=" + lifeTime + ", createTime="
				+ createTime + "]";
	}
	
	
}
