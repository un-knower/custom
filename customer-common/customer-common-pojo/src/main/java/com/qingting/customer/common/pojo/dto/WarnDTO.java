package com.qingting.customer.common.pojo.dto;

public class WarnDTO {
	private String equipCode;
	/**
	 * 图片路径
	 */
	private String path;
	
	/**
	 * 设备名称
	 */
	private String equipName;
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
	

	public String getEquipCode() {
		return equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
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
