package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

public class ComParamRowKey implements RowKey,Serializable {
	
	private static final long serialVersionUID = 351119392364689401L;
	private byte[] bytes = new byte[16];
	/**
	 * 状态：true失能
	 */
	private Boolean enable;
	/**
	 * 时间
	 */
	private Calendar calendar;
	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description: 实例化行健参数，取当前时间</p>
	 * @param enable
	 */
	public ComParamRowKey(Boolean enable){
		this.enable=enable;
		this.calendar=Calendar.getInstance();
		toBytes();
	}
	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description: 实例化行健参数，取传入的参数时间</p>
	 * @param enable
	 * @param calendar
	 */
	public ComParamRowKey(Boolean enable,Calendar calendar) {
		this.enable=enable;
		this.calendar = Calendar.getInstance();
		toBytes();
	}

	@Override
	public byte[] toBytes() {
		int i = 0;
		// Enable 1字节
		byte[] userIdOfBytes = Bytes.toBytes(enable);
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
