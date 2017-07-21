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
	private static final Map<String,Object> project=new HashMap<String,Object>(){
		{
			put("family",new String[]{"projectFamily"});
		}
	};
	private static final Map<String,Object> equip=new HashMap<String,Object>(){
		{
			put("family",new String[]{"equipFamily"});
		}
	};
	private static final Map<String,Object> equipSort=new HashMap<String,Object>(){
		{
			put("family",new String[]{"equipSortFamily"});
		}
	};
	private static final Map<String,Object> monitor=new HashMap<String,Object>(){
	
		private static final long serialVersionUID = 9112245605102867437L;
		{
			put("family",new String[]{"monitorFamily"});
			put("split",getMonitorBytes(10,20)
			);
		}
	};
	private static final Map<String,Object> user=new HashMap<String,Object>(){
		{
			put("family",new String[]{"userFamily"});
		}
	};
	private static final Map<String,Object> userSort=new HashMap<String,Object>(){
		{
			put("family",new String[]{"userSortFamily"});
		}
	};
	private static final Map<String,Object> message=new HashMap<String,Object>(){
		{
			put("family",new String[]{"messageFamily"});
		}
	};
	private static final Map<String,Object> messageIndex=new HashMap<String,Object>(){
		{
			put("family",new String[]{"messageIndexFamily"});
		}
	};
	private static final Map<String,Object> messageSort=new HashMap<String,Object>(){
		{
			put("family",new String[]{"messageSortFamily"});
		}
	};
	private static final Map<String,Object> province=new HashMap<String,Object>(){
		{
			put("family",new String[]{"provinceFamily"});
		}
	};
	private static final Map<String,Object> city=new HashMap<String,Object>(){
		{
			put("family",new String[]{"cityFamily"});
			put("split",
				new byte[][]{
     		   		{49,0,0,0,0,0,0,0,0,0,0,0},
    				{50,0,0,0,0,0,0,0,0,0,0,0}, 
    				{51,0,0,0,0,0,0,0,0,0,0,0}, 
    				{52,0,0,0,0,0,0,0,0,0,0,0}, 
    				{53,0,0,0,0,0,0,0,0,0,0,0},    
    				{54,0,0,0,0,0,0,0,0,0,0,0}, 
    				{55,0,0,0,0,0,0,0,0,0,0,0}, 
    				{56,0,0,0,0,0,0,0,0,0,0,0}, 
    				{57,0,0,0,0,0,0,0,0,0,0,0} 
     		   	}
			);
		}
	};
	private static final Map<String,Object> area=new HashMap<String,Object>(){
		{
			put("family",new String[]{"areaFamily"});
			put("split",
				new byte[][]{
     		   		{49,0,0,0,0,0,0,0,0,0,0,0},
    				{50,0,0,0,0,0,0,0,0,0,0,0}, 
    				{51,0,0,0,0,0,0,0,0,0,0,0}, 
    				{52,0,0,0,0,0,0,0,0,0,0,0}, 
    				{53,0,0,0,0,0,0,0,0,0,0,0},    
    				{54,0,0,0,0,0,0,0,0,0,0,0}, 
    				{55,0,0,0,0,0,0,0,0,0,0,0}, 
    				{56,0,0,0,0,0,0,0,0,0,0,0}, 
    				{57,0,0,0,0,0,0,0,0,0,0,0} 
     		   	}
			);
		}
	};
	/**
	 * key:表名 
	 * value:列族+预分区
	 */
	private static final Map<String,Map<String,Object>> map=new HashMap<String,Map<String,Object>>(){
		private static final long serialVersionUID = 9112245605102867437L;
		{
			put("project", project);
			put("equip", equip);
			put("equipSort", equipSort);
			put("monitor", monitor);
			put("user", user);
			put("userSort",userSort);
			put("message", message);
			put("messageIndex", messageIndex);
			put("messageSort", messageSort);
			put("province",province);
			put("city",city);
			put("area",area);
		}
	};
	
	
	private static byte[][] getMonitorBytes(int row,int cloumn){
		byte[][] bytes=new byte[row][cloumn];
		for(int i=0;i<row;i++){
			bytes[i][0]=(byte)( (256/row)*i ) ;
			for(int j=1;j<cloumn;j++){
				bytes[i][j]=(byte)0x00;
			}
		}
		return bytes;
	}
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
