package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * 
 * @ClassName: MonitorRowKey
 * @Description: 行健组成:设备ID(4字节)+距DateUtil.start的天数(2字节)+距凌晨的毫秒数(4字节)
 * @author zlf
 * @date 2017年4月24日 下午5:28:15
 *
 */
public class MonitorRowKey implements RowKey,Serializable{

	private static final long serialVersionUID = 5920603862943181902L;
	private byte[] bytes = new byte[16];

	/**
	 * 设备外键
	 */
	private int equipId;

	/**
	 * 时间
	 */
	private Calendar cal;
	/*
	 * 做好自增序列，可以考虑监测编号
	 */
	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description:实例化行健参数，取当前时间 </p>
	 * @param equipId
	 */
	public MonitorRowKey(int equipId) {
		this.equipId = equipId;
		this.cal = Calendar.getInstance();
		toBytes();
	}

	/**
	 * 
	 * <p>Title: </p>
	 * <p>Description:实例化行健参数，取传入的时间参数 </p>
	 * @param equipId
	 * @param cal
	 */
	public MonitorRowKey(int equipId, Calendar cal) {
		this.equipId = equipId;
		this.cal = cal;
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
		// cal距离指定时间(DateUtil.start)的天数 2字节
		byte[] dayOfStart = Bytes.toBytes(DateUtil.getDayOfStart(cal));
		for (int j = 0; j < dayOfStart.length; j++) {
			bytes[i] = dayOfStart[j];
			i++;
		}
		// 距离cal日期，时间00:00:00.000的毫秒数 4字节
		byte[] millis = Bytes.toBytes(DateUtil.getMillisOfDay(cal));
		for (int j = 0; j < millis.length; j++) {
			bytes[i] = millis[j];
			i++;
		}
		// for (byte b : bytes) {
		// System.out.print(b + " ");
		// }
		// System.out.println("调用一次。。");
		return bytes;
	}

	@Override
	public String toString() {
		return new String(bytes);
	}
}
