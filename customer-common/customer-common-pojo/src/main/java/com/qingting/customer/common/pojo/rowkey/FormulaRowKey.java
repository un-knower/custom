package com.qingting.customer.common.pojo.rowkey;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.hbase.rowkey.RowKey;

public class FormulaRowKey implements RowKey,Serializable{

	private static final long serialVersionUID = -9146271641101677891L;
	private byte[] bytes = new byte[16];
	/**
	 * 时间
	 */
	private Calendar calendar;
	
	public FormulaRowKey(){
		this.calendar=Calendar.getInstance();
		toBytes();
	}
	public FormulaRowKey(Calendar calendar){
		this.calendar=calendar;
		toBytes();
	}
	
	@Override
	public byte[] toBytes() {
		int i = 0;
		// 距离START时间的毫秒数 8字节
		byte[] millis = Bytes.toBytes(DateUtil.getMillisOfStart(calendar));
		for (int j = 0; j < millis.length; j++) {
			bytes[i] = millis[j];
			i++;
		}
		return bytes;
	}
}
