package com.qingting.customer.controller.request;

public class MessageListRequest {
	private Byte[] endRowKey;
	private String sortCode;
	public Byte[] getEndRowKey() {
		return endRowKey;
	}
	public void setEndRowKey(Byte[] endRowKey) {
		this.endRowKey = endRowKey;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	
}
