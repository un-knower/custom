package com.alipay.simplehbase.client.rowkey.handler;

import com.qingting.customer.hbase.rowkey.RowKey;

/**
 * Convert hbase's rowkey to rowkey object.
 * 
 * @author xinzhi
 * */
public interface RowKeyHandler {

    /**
     * Convert hbase row key bytes to rowkey Object.
     * 
     * @param row hbase row key.
     * @return rowkey Object.
     * */
    public RowKey convert(byte[] row);
}
