package com.qingting.customer.model;

import java.util.Calendar;

import com.smart.mvc.model.PersistentObject;

public class WaterQuality extends PersistentObject{
	
	private static final long serialVersionUID = 8839461036140841912L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 浊度
	 */
	private Float turbidity;
	/**
	 * 余氯
	 */
	private Float chlorine;
	/**
	 * 自来水公司Id
	 */
	private Integer waterAreaId;
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
	public Float getTurbidity() {
		return turbidity;
	}
	public void setTurbidity(Float turbidity) {
		this.turbidity = turbidity;
	}
	public Float getChlorine() {
		return chlorine;
	}
	public void setChlorine(Float chlorine) {
		this.chlorine = chlorine;
	}
	public Integer getWaterAreaId() {
		return waterAreaId;
	}
	public void setWaterAreaId(Integer waterAreaId) {
		this.waterAreaId = waterAreaId;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	
	
}
