package com.alipay.simplehbase.util;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class ConnectionUtil {
	private static Configuration cfg = null;
	private static Connection conn = null;
	static {
		cfg=ConfigUtil.getHbaseDataSource().getHbaseConfiguration();
		try {
			conn = ConnectionFactory.createConnection(cfg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
}
