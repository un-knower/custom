package com.qingting.customer.dao.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	/**
	 * key:表名 
	 * value:列族+预分区
	 */
	private static final Map<String,Map<String,Object>> map=new HashMap<String,Map<String,Object>>(){
		private static final long serialVersionUID = 9112245605102867437L;
		{
			put("project", new HashMap<String,Object>());
			put("equip", new HashMap<String,Object>());
			put("equipSort", new HashMap<String,Object>());
			put("monitor", new HashMap<String,Object>());
			put("user", new HashMap<String,Object>());
			put("userSort",new HashMap<String,Object>());
			put("message", new HashMap<String,Object>());
			put("messageSort", new HashMap<String,Object>());
			put("province",new HashMap<String,Object>());
			put("city",new HashMap<String,Object>());
			put("area",new HashMap<String,Object>());
			
			
			put("messageIndex", new HashMap<String,Object>());
			put("monitorIndex", new HashMap<String,Object>());
			put("monitorIndexDay", new HashMap<String,Object>());
			put("equipIndex", new HashMap<String,Object>());
			put("attention", new HashMap<String,Object>());
			
			put("waterArea",new HashMap<String,Object>());
			put("waterQuality",new HashMap<String,Object>());
			put("filterGroup",new HashMap<String,Object>());
			put("filter",new HashMap<String,Object>());
			put("formula",new HashMap<String,Object>());
			put("microFormula",new HashMap<String,Object>());
			
		}
	};
	
	
	/*private static byte[][] getMonitorBytes(int row,int cloumn){
		byte[][] bytes=new byte[row][cloumn];
		for(int i=0;i<row;i++){
			bytes[i][0]=(byte)( (256/row)*i ) ;
			for(int j=1;j<cloumn;j++){
				bytes[i][j]=(byte)0x00;
			}
		}
		return bytes;
	}*/
	public static void main(String[] args){//增加协处理器
   		String coprocessClassName = "org.apache.hadoop.hbase.coprocessor.AggregateImplementation";
       Admin admin=AdminUtil.getAdmin();
       for (String str: map.keySet()) {
    	   String tablename=str;
	       try {
				admin.disableTable(TableNameUtil.getTableName(tablename));
				HTableDescriptor htd = admin.getTableDescriptor(TableNameUtil.getTableName(tablename));
		        htd.addCoprocessor(coprocessClassName);
		        admin.modifyTable(TableNameUtil.getTableName(tablename), htd);
		        admin.enableTable(TableNameUtil.getTableName(tablename));
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(admin.isTableDisabled(TableNameUtil.getTableName(tablename)))
						admin.enableTable(TableNameUtil.getTableName(tablename));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
       }
   }
   /* public static void main(String[] args){//协处理器计数测试
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
    }*/
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
