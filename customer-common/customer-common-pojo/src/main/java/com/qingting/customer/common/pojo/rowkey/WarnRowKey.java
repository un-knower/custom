package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

public class WarnRowKey implements RowKey,Serializable{
	
	private static final long serialVersionUID = -6973607877907320916L;
	private byte[] bytes = new byte[16];
	/**
	 * 设备ID
	 */
	private Integer equipId;
	/**
	 * 时间
	 */
	private Calendar calendar;
	public WarnRowKey(Integer equipId){
		this.equipId=equipId;
		toBytes();
	}
	public WarnRowKey(Integer equipId,Calendar calendar){
		this.equipId=equipId;
		this.calendar=calendar;
		toBytes();
	}
	@Override
	public byte[] toBytes() {
		int i = 0;
		// 设备ID 4字节
		byte[] userIdOfBytes = Bytes.toBytes(equipId);
		for (int j = 0; j < userIdOfBytes.length; j++) {
			bytes[i] = userIdOfBytes[j];
			i++;
		}
		// 距离START时间的毫秒数 8字节
		byte[] millis = Bytes.toBytes(DateUtil.getMillisOfStart(calendar));
		for (int j = 0; j < millis.length; j++) {
			bytes[i] = millis[j];
			i++;
		}
		return bytes;
	}
}
