package com.qingting.customer.common.pojo.hbasedo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Monitor implements Serializable{

	private static final long serialVersionUID = -3476260854075534540L;

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
	private Float temp;

	/**
	 * 湿度值
	 */
	private Float humidity;

	/**
	 * 流量值
	 */
	private Float flow;

	/**
	 * 漏水状态开关：true-漏水、false-无漏水
	 */
	private Boolean leak;

	/**
	 * d值
	 */
	private Float d;

	/**
	 * w值
	 */
	private Float w;

	/**
	 * 数据的版本，更新时用，监测数据只需要一个版本
	 */
	private final Byte version = 0;

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

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getHumidity() {
		return humidity;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public Float getFlow() {
		return flow;
	}

	public void setFlow(Float flow) {
		this.flow = flow;
	}

	public Boolean getLeak() {
		return leak;
	}

	public void setLeak(Boolean leak) {
		this.leak = leak;
	}

	public Float getD() {
		return d;
	}

	public void setD(Float d) {
		this.d = d;
	}

	public Float getW() {
		return w;
	}

	public void setW(Float w) {
		this.w = w;
	}

	public Byte getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
