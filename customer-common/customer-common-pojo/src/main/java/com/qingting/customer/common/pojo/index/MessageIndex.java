package com.qingting.customer.common.pojo.index;

import com.qingting.customer.hbase.rowkey.RowKey;

public class MessageIndex {
	
	private String rowkey;
	/**
	 * 
	 */
	private String value;
	
	public String getRowkey() {
		return rowkey;
	}
	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
