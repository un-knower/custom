package com.qingting.customer.common.pojo.dto;

public class HomeMonitorDTO {
	/**
	 * 消息类型 
	 */
	private Integer msgType;
	/**
	 * 监测次数
	 */
	private Integer moitorCount;
	/**
	 * 服务次数
	 */
	private Integer serviceCount;
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
	
	
	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getMoitorCount() {
		return moitorCount;
	}

	public void setMoitorCount(Integer moitorCount) {
		this.moitorCount = moitorCount;
	}

	public Integer getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(Integer serviceCount) {
		this.serviceCount = serviceCount;
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
	
}
