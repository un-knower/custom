package com.alipay.simplehbase.util;

import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;

public class AggregationClientUtil {
	/**
	 * Get AggregationClient.
	 * */
	public static AggregationClient getAggregationClient() {
		AggregationClient aggregationClient = new AggregationClient(
				ConnectionUtil.getCfg());
		return aggregationClient;
	}
}
