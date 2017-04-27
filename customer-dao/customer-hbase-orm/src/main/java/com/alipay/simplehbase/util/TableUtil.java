package com.alipay.simplehbase.util;

import java.io.IOException;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;

import com.alipay.simplehbase.exception.SimpleHBaseException;

public class TableUtil {
	public static Table getTable(String tableName) {
		Util.checkEmptyString(tableName);
		try {
			return ConnectionUtil.getConnection().getTable(
					TableName.valueOf(tableName));
		} catch (IOException e) {
			throw new SimpleHBaseException("error.obtain table fail.", e);
		}
	}

	public static Table getTable(TableName tableName) {
		Util.checkNull(tableName);
		try {
			return ConnectionUtil.getConnection().getTable(tableName);
		} catch (IOException e) {
			throw new SimpleHBaseException("error.obtain table fail.", e);
		}
	}
}
