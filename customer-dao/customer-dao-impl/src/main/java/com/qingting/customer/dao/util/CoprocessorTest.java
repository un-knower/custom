package com.qingting.customer.dao.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;

import com.alipay.simplehbase.client.SimpleHbaseClient;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.alipay.simplehbase.util.AdminUtil;
import com.alipay.simplehbase.util.ConnectionUtil;
import com.alipay.simplehbase.util.FilterUtils;
import com.alipay.simplehbase.util.TableNameUtil;
import com.google.common.collect.Lists;

public class CoprocessorTest {
	//private static SimpleHbaseClient tClient=SHCUtil.getSHC("area");
	
    /*public static void main(String[] args){//增加协处理器
    	String coprocessClassName = "org.apache.hadoop.hbase.coprocessor.AggregateImplementation";
        Admin admin=AdminUtil.getAdmin();
        try {
			admin.disableTable(TableNameUtil.getTableName("area"));
			HTableDescriptor htd = admin.getTableDescriptor(TableNameUtil.getTableName("area"));
	        htd.addCoprocessor(coprocessClassName);
	        admin.modifyTable(TableNameUtil.getTableName("area"), htd);
	        admin.enableTable(TableNameUtil.getTableName("area"));
		} catch (IOException e) {
			e.printStackTrace();
		}

        
    }*/
    public static void main(String[] args){//协处理器计数测试
    	try {
    		String code="12011";
    		Connection connection = ConnectionUtil.getConnection();
    		Configuration cfg = connection.getConfiguration();
    		TableNameUtil.getTableName("area");
            Scan scan = constructScan(RowKeyUtil.getRowKey(Common.MINCITYCODE,code).toBytes(), RowKeyUtil.getRowKey(Common.MAXCITYCODE,code).toBytes(), -1,FilterUtils.getContainFilter(code));

            LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
            AggregationClient aggregationClient = new AggregationClient(
    				cfg);
            //AggregationClient aggregationClient = aggregationClient();

            // No need to close HTable,the AggregationClient close it.
            System.out.println("计数："+aggregationClient.rowCount(TableNameUtil.getTableName("area"),
                            columnInterpreter, scan));
        } catch (Throwable e) {
            throw new SimpleHBaseException(e);
        }
    }
    private static Scan constructScan(byte[] startRow, byte[] endRow, int pageSize, Filter... filters) {
        Scan scan = new Scan();
        if (startRow != null) {
            scan.setStartRow(startRow);
        }

        if (endRow != null) {
            scan.setStopRow(endRow);
        }

        List<Filter> filterList = Lists.newArrayList();
        if (pageSize != -1) {
            filterList.add(new PageFilter(pageSize));
        }

        if (filters != null && filters.length > 0) {
            filterList.addAll(Arrays.asList(filters));
        }

        if (filterList.size() > 0) {
            FilterList f = new FilterList(filterList.toArray(new Filter[filterList.size()]));
            scan.setFilter(f);
        }

        scan.setCaching(100);
        // scan.setBatch(scanBatch);
        return scan;
    }
}
