package com.alipay.simplehbase.client.service;

import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Table;

/**
 * HbaseService
 * 
 * @author xinzhi.zhang
 * 
 * */

public interface HbaseService {

	/**
	 * Get a reference to the specified table.
	 * 
	 * @param tableName
	 *            table name
	 * @return a reference to the specified table
	 */
	@Deprecated
	public HTableInterface getHTable(String tableName);

	/**
	 * Get HBaseAdmin.
	 * 
	 * @return HBaseAdmin
	 * */
	@Deprecated
	public HBaseAdmin getHBaseAdmin();

	/**
	 * Get a reference to the specified table. add in 1.2.4
	 * 
	 * @param tableName
	 *            table name
	 * @return a reference to the specified table
	 */
	public Table getTable(String tableName);

	/**
	 * Get Admin. add in 1.2.4
	 * 
	 * @return Admin
	 * */
	public Admin getAdmin();
}
