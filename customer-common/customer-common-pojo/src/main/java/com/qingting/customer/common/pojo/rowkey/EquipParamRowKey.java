package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

public class EquipParamRowKey implements RowKey,Serializable{

	private static final long serialVersionUID = -4646854669237256242L;
	private byte[] bytes = new byte[16];
	/**
	 * 用户ID
	 */
	private Integer equipId;
	/**
	 * 状态：true失能
	 */
	private Boolean enable;
	/**
	 * 时间
	 */
	private Calendar calendar;
	
	public EquipParamRowKey(Integer equipId,Boolean enable) {
		this.equipId = equipId;
		this.enable=enable;
		this.calendar=Calendar.getInstance();
		toBytes();
	}
	public EquipParamRowKey(Integer equipId,Boolean enable,Calendar calendar) {
		this.equipId = equipId;
		this.enable=enable;
		this.calendar=calendar;
		toBytes();
	}
	@Override
	public byte[] toBytes() {
		int i = 0;
		// 设备ID 4字节
		byte[] equipIdOfBytes = Bytes.toBytes(equipId);
		for (int j = 0; j < equipIdOfBytes.length; j++) {
			bytes[i] = equipIdOfBytes[j];
			i++;
		}
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
