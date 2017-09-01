package com.qingting.customer.model.hbasedo;

import java.util.Calendar;

import com.alibaba.fastjson.annotation.JSONField;
import com.qingting.customer.model.common.PersistentObject;

import io.swagger.annotations.ApiModelProperty;


public class Monitor extends PersistentObject{

	private static final long serialVersionUID = -3476260854075534540L;
	
	/**
	 * ID
	 */
	private Long id;
	
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
	 * 电磁阀输出状态 true:电磁阀供电 false:电池阀不供电
	 */
	private Boolean magnetic;
	
	/**
	 * 输出继电器 true:闭合 false:断开
	 */
	private Boolean outRelay;
	
	/**
	 * 电源继电器 true:有输出 false:无输出
	 */
	private Boolean powerRelay;
	/**
	 * 一级滤芯计算结果
	 */
	private Float oneResult;
	/**
	 * 二级滤芯计算结果
	 */
	private Float twoResult;
	/**
	 * 三级滤芯结算结果
	 */
	private Float threeResult;
	/**
	 * 四级滤芯计算结果
	 */
	private Float fourResult;
	/**
	 * 五级滤芯计算结果 
	 */
	private Float fiveResult;
	/**
	 * 微生物计算结果
	 */
	private Float microResult;
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Boolean getMagnetic() {
		return magnetic;
	}
	public void setMagnetic(Boolean magnetic) {
		this.magnetic = magnetic;
	}
	public Boolean getOutRelay() {
		return outRelay;
	}
	public void setOutRelay(Boolean outRelay) {
		this.outRelay = outRelay;
	}
	public Boolean getPowerRelay() {
		return powerRelay;
	}
	public void setPowerRelay(Boolean powerRelay) {
		this.powerRelay = powerRelay;
	}
	public Float getOneResult() {
		return oneResult;
	}
	public void setOneResult(Float oneResult) {
		this.oneResult = oneResult;
	}
	public Float getTwoResult() {
		return twoResult;
	}
	public void setTwoResult(Float twoResult) {
		this.twoResult = twoResult;
	}
	public Float getThreeResult() {
		return threeResult;
	}
	public void setThreeResult(Float threeResult) {
		this.threeResult = threeResult;
	}
	public Float getFourResult() {
		return fourResult;
	}
	public void setFourResult(Float fourResult) {
		this.fourResult = fourResult;
	}
	public Float getFiveResult() {
		return fiveResult;
	}
	public void setFiveResult(Float fiveResult) {
		this.fiveResult = fiveResult;
	}
	public Float getMicroResult() {
		return microResult;
	}
	public void setMicroResult(Float microResult) {
		this.microResult = microResult;
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
	@Override
	public String toString() {
		return "Monitor [id=" + id + ", rawTds=" + rawTds + ", purTds=" + purTds + ", temp=" + temp + ", humidity="
				+ humidity + ", flow=" + flow + ", leak=" + leak + ", magnetic=" + magnetic + ", outRelay=" + outRelay
				+ ", powerRelay=" + powerRelay + ", oneResult=" + oneResult + ", twoResult=" + twoResult
				+ ", threeResult=" + threeResult + ", fourResult=" + fourResult + ", fiveResult=" + fiveResult
				+ ", microResult=" + microResult + ", equipCode=" + equipCode + ", collectTime=" + collectTime
				+ ", createTime=" + createTime + "]";
	}
	
	
}
