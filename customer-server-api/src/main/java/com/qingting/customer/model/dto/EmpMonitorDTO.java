package com.qingting.customer.model.dto;

import java.util.Calendar;

import com.alibaba.fastjson.annotation.JSONField;
import com.smart.mvc.model.PersistentObject;

import io.swagger.annotations.ApiModelProperty;

public class EmpMonitorDTO extends PersistentObject{
	
	private static final long serialVersionUID = 3301909046061563598L;

	/**
	 * 原水TDS值
	 */
	private Float rawTds;

	/**
	 * 净水TDS值
	 */
	private Float purTds;

	/**
	 * 温度值
	 */
	private Byte temp;

	/**
	 * 湿度值
	 */
	private Byte humidity;

	/**
	 * 流量值
	 */
	private Long flow;

	/**
	 * 漏水状态开关：true-漏水、false-无漏水
	 */
	private Boolean leak;
	/**
	 * 设备编号
	 */
	private String equipCode;
	/**
	 * 采集时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="时间",example="2017-01-01 12:00:00",dataType="String")
	private Calendar collectTime;
	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="时间",example="2017-01-01 12:00:00",dataType="String")
	private Calendar createTime;
	/**
	 * 用户手机
	 */
	private String userMobile;
	/**
	 * 用户名
	 */
	private String userName;
	public Float getRawTds() {
		return rawTds;
	}
	public void setRawTds(Float rawTds) {
		this.rawTds = rawTds;
	}
	public Float getPurTds() {
		return purTds;
	}
	public void setPurTds(Float purTds) {
		this.purTds = purTds;
	}
	public Byte getTemp() {
		return temp;
	}
	public void setTemp(Byte temp) {
		this.temp = temp;
	}
	public Byte getHumidity() {
		return humidity;
	}
	public void setHumidity(Byte humidity) {
		this.humidity = humidity;
	}
	public Long getFlow() {
		return flow;
	}
	public void setFlow(Long flow) {
		this.flow = flow;
	}
	public Boolean getLeak() {
		return leak;
	}
	public void setLeak(Boolean leak) {
		this.leak = leak;
	}
	public String getEquipCode() {
		return equipCode;
	}
	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	public Calendar getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Calendar collectTime) {
		this.collectTime = collectTime;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
