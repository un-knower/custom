package com.qingting.customer.common.pojo.dto;

public class HomeMonitorDTO {
	
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
	 * 流量值
	 */
	private Long flow;

	/**
	 * 漏水状态开关：true-漏水、false-无漏水
	 */
	private Boolean leak;
	
	/**
	 * 我的设备总数
	 */
	private Integer mineEquip;
	
	/**
	 * 关注的设备总数
	 */
	private Integer attentEquip;


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

	public Integer getMineEquip() {
		return mineEquip;
	}

	public void setMineEquip(Integer mineEquip) {
		this.mineEquip = mineEquip;
	}

	public Integer getAttentEquip() {
		return attentEquip;
	}

	public void setAttentEquip(Integer attentEquip) {
		this.attentEquip = attentEquip;
	}

	
	
	
}
