package com.alipay.simplehbase.type.handler;

import com.alipay.simplehbase.type.AbstractTypeHandler;

public class ByteArrayHandler extends AbstractTypeHandler {

	@Override
	protected boolean aboutToHandle(Class<?> type) {
		return type==byte[].class || type == Byte[].class;
	}

	@Override
	protected byte[] innerToBytes(Class<?> type, Object value) {
		return (byte[])value;
	}

	@Override
	protected Object innerToObject(Class<?> type, byte[] bytes) {
		return bytes;
	}

}
