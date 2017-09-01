package com.alipay.simplehbase.util;

import java.io.IOException;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	/** log. */
	final private static Logger log = LoggerFactory.getLogger(TableUtil.class);
	/**
	 * 
	 * @Title: createTableBySplitKeys
	 * @Description: 建表，如指定预分区，则预分区
	 * @param tableName
	 * @param columnFamily
	 * @param keys
	 * @return 
	 * @return boolean
	 * @throws
	 */
	public static boolean createTableBySplitKeys(String tableName, String[] columnFamily,byte[][] keys) {    
		try {    
			if (StringUtil.isEmptyString(tableName) || columnFamily == null    
	               || columnFamily.length < 0) {    
				log.error("===Parameters tableName|columnFamily should not be null,Please check!===");    
			}    
			Admin admin = AdminUtil.getAdmin();    
			if (admin.tableExists(TableNameUtil.getTableName(tableName))) {    
				return true;    
			} else {    
				HTableDescriptor tableDescriptor = new HTableDescriptor(    
	        		   TableNameUtil.getTableName(tableName));    
				for (String cf : columnFamily) {    
					tableDescriptor.addFamily(new HColumnDescriptor(cf));    
				}    
				if(keys!=null && keys.length!=0){//预分区
					admin.createTable(tableDescriptor,keys);//指定splitkeys    
				}else{//没有预分区
					admin.createTable(tableDescriptor);
				}
				log.info("===Create Table " + tableName    
	                   + " Success!columnFamily:" + columnFamily.toString()    
	                   + "===");    
			}    
		} catch (MasterNotRunningException e) {    
			e.printStackTrace(); 
			return false;    
		} catch (ZooKeeperConnectionException e) {    
			e.printStackTrace();   
			return false;    
		} catch (IOException e) {    
			e.printStackTrace();    
			return false;    
		}    
		return true;    
	} 
	public static void tryCreateTable(String tableName, String[] columnFamily,byte[][] keys){
		try {
			if(AdminUtil.getAdmin().tableExists(TableNameUtil.getTableName(tableName))){
				log.info("表存在："+tableName);
			}else{
				log.info("表不存在，正在建表:"+tableName);
				createTableBySplitKeys(tableName,columnFamily,keys);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
