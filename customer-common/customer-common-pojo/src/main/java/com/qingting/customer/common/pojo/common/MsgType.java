package com.qingting.customer.common.pojo.common;

public enum MsgType {
	WARN(1);
	
	private Integer value;
	
	private MsgType(Integer value){
		this.value=value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
