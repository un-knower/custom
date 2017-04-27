package com.alipay.simplehbase.util;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Admin;

import com.alipay.simplehbase.exception.SimpleHBaseException;

public class AdminUtil {
	public static Admin getAdmin() {
		try {
			return ConnectionUtil.getConnection().getAdmin();
		} catch (IOException e) {
			throw new SimpleHBaseException("error.obtain admin fail.", e);
		}
	}
}
