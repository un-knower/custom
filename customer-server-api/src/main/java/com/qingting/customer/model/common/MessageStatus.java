package com.qingting.customer.model.common;

public enum MessageStatus {
	//服务提醒
	FWTX_WAIT_SERVICE("待服务"),
	FWTX_ALREADY_SERVICE("已服务"),
	//服务评价
	FWPJ_WAIT_EVALUATE("待评价"),
	FWPJ_ALREADY_EVALUATE("已评价"),
	//申请关注
	SQGZ_WAIT_HANDLE("待处理"),
	SQGZ_ALREADY_AGREE("已同意"),
	SQGZ_ALREADY_REFUSE("已拒绝"),
	
	//续费提醒
	XFTX_WAIT_RENEW("待续费"),
	XFTX_ALREADY_RENEW("完成续费");
	
	private String status;
	
	private MessageStatus(String status){
		this.status=status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
