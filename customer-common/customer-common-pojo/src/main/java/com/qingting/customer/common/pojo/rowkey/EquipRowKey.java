package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

public class EquipRowKey implements RowKey,Serializable{
	private static final long serialVersionUID = -1750111410848024076L;
	private byte[] bytes = new byte[16];
	
	/**
	 * 项目ID
	 */
	private Integer projectId;
	/**
	 * 时间
	 */
	private Calendar calendar;
	/*
	 * 做好自增序列，可以考虑设备编号
	 */
	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description: 实例化行健参数，取当前时间</p>
	 * @param projectId
	 */
	public EquipRowKey(Integer projectId){
		this.projectId=projectId;
		this.calendar=Calendar.getInstance();
		toBytes();
	}
	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description: 实例化行健参数，取传入的参数时间</p>
	 * @param projectId
	 * @param calendar
	 */
	public EquipRowKey(Integer projectId,Calendar calendar){
		this.projectId=projectId;
		this.calendar=calendar;
		toBytes();
	}
	
	@Override
	public byte[] toBytes() {
		int i = 0;
		// 项目ID 4字节
		byte[] userIdOfBytes = Bytes.toBytes(projectId);
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
