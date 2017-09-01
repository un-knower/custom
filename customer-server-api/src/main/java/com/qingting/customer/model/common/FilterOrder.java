package com.qingting.customer.model.common;

public enum FilterOrder {
	ONE((byte)1),
	TWO((byte)2),
	THREE((byte)3),
	FOUR((byte)4),
	FIVE((byte)5)
	;
	
	private Byte order;
	
	private FilterOrder(Byte order){
		this.order=order;
	}

	public Byte getOrder() {
		return order;
	}

	public void setOrder(Byte order) {
		this.order = order;
	}
	
	
}
