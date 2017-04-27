package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

public class AttentionRowKey implements RowKey,Serializable{

	private static final long serialVersionUID = -4824128626403471909L;
	private byte[] bytes = new byte[16];
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 时间
	 */
	private Calendar calendar;
	
	public AttentionRowKey(Integer userId) {
		this.userId = userId;
		this.calendar=Calendar.getInstance();
		toBytes();
	}
	public AttentionRowKey(Integer userId,Calendar calendar) {
		this.userId = userId;
		this.calendar=calendar;
		toBytes();
	}


	@Override
	public byte[] toBytes() {
		int i = 0;
		// 用户ID 4字节
		byte[] userIdOfBytes = Bytes.toBytes(userId);
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
