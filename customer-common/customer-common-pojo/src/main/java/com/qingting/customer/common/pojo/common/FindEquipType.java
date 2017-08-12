package com.qingting.customer.common.pojo.common;

public enum FindEquipType {
	MINE("mine"),
	ATTENT("attent");
	
	private String type;
	
	private FindEquipType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
