package com.qingting.customer.model;

import java.io.Serializable;

import com.qingting.operation.model.ServerDTO;

public class SummaryServer implements Serializable{
	
	private static final long serialVersionUID = 511013961124589971L;
	
	private ServerDTO server;
	/**
	 * 图像路径
	 */
	private String equipSortImage;
	/**
	 * 备注
	 */
	private String equipMark;
	public ServerDTO getServer() {
		return server;
	}
	public void setServer(ServerDTO server) {
		this.server = server;
	}
	public String getEquipSortImage() {
		return equipSortImage;
	}
	public void setEquipSortImage(String equipSortImage) {
		this.equipSortImage = equipSortImage;
	}
	public String getEquipMark() {
		return equipMark;
	}
	public void setEquipMark(String equipMark) {
		this.equipMark = equipMark;
	}
	
	
}
