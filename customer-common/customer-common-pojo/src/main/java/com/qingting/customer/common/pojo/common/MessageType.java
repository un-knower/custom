package com.qingting.customer.common.pojo.common;

public enum MessageType {
	SERVICE_REMIND("fwtx"),//服务提醒
	SERVICE_EVALUATE("fwpj"),//服务评价
	APPLY_ATTENT("sqgz"),//申请关注
	RENEW_REMIND("xftx");
	
	private String code;
	
	private MessageType(String code){
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
