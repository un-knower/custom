package com.qingting.customer.enums;

public enum AttentStatus {
	CHECK((byte)0),
	PASS((byte)1),
	REFUSE((byte)2);
	
	private byte value;
	
	private AttentStatus(byte value){
		this.value=value;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}
	
}
