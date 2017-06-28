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
		cfg = HBaseConfiguration.create();
		cfg.set("hbase.zookeeper.quorum", "39.108.52.201");
		cfg.set("hbase.zookeeper.property.clientPort", "2181"); 
		try {
			conn = ConnectionFactory.createConnection(cfg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
}
