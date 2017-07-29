package com.qingting.customer.hbase.rowkey;

import java.nio.charset.Charset;

public class RowKeyParam implements RowKey {
	private String rowkey;
	@Override
	public byte[] toBytes() {
		return rowkey.getBytes(Charset.forName("UTF-8"));
	}
	public String getRowkey() {
		return rowkey;
	}
	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}
	
}
