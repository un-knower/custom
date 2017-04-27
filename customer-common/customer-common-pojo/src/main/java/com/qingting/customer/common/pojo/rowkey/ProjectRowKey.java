package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;
/**
 * 
 * @ClassName: ProjectRowKey
 * @Description: 行健组成:设备ID(4字节)+GMT毫秒数(8字节)
 * @author zlf
 * @date 2017年4月24日 下午5:30:00
 *
 */
public class ProjectRowKey implements RowKey,Serializable{
	private static final long serialVersionUID = -7491359432436768174L;
	private byte[] bytes = new byte[16];
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 时间
	 */
	private Calendar calendar;
	/*
	 * 做好自增序列，可以考虑项目编号
	 */
	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description: 实例化行健参数，取当前时间</p>
	 * @param userId
	 */
	public ProjectRowKey(Integer userId){
		this.userId=userId;
		this.calendar=Calendar.getInstance();
		toBytes();
	}
	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description: 实例化行健参数，取传入的参数时间</p>
	 * @param userId
	 * @param calendar
	 */
	public ProjectRowKey(Integer userId,Calendar calendar){
		this.userId=userId;
		this.calendar=calendar;
		toBytes();
	}
	
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
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
