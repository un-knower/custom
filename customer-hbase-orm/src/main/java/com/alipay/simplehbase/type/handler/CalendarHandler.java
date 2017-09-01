package com.alipay.simplehbase.type.handler;


import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.hbase.util.Bytes;

import com.alipay.simplehbase.type.AbstractTypeHandler;

public class CalendarHandler extends AbstractTypeHandler {

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type == Calendar.class;
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		long time = ((Calendar) value).getTimeInMillis();
		return Bytes.toBytes(time);
	}

	@Override
	protected Object innerToObject(Class<?> type, byte[] bytes) {
		long time = Bytes.toLong(bytes);
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar;
	}

}
