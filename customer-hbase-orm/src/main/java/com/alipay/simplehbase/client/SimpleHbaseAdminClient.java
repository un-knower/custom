package com.alipay.simplehbase.client;

import org.apache.hadoop.hbase.HTableDescriptor;

import com.alipay.simplehbase.client.service.HBaseDataSourceAware;


/**
 * SimpleHbaseAdminClient.
 * 
 * @author xinzhi
 * */
public interface SimpleHbaseAdminClient extends HBaseDataSourceAware {

    /**
     * Creates a new table. Synchronous operation.
     */
    public void createTable(HTableDescriptor tableDescriptor);

    /**
     * Deletes a table. Synchronous operation.
     */
    public void deleteTable(final String tableName);
}
