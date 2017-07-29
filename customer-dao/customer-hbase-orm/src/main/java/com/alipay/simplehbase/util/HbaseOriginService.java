package com.alipay.simplehbase.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.simplehbase.client.QueryExtInfo;
import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.core.Nullable;
import com.alipay.simplehbase.exception.SimpleHBaseException;
import com.qingting.customer.hbase.rowkey.RowKey;


public class HbaseOriginService {
	/** log. */
	final private static Logger log = LoggerFactory.getLogger(HbaseOriginService.class);
	
	private String tableName;
	
	public HbaseOriginService(String tableName, String[] columnFamily,byte[][] keys) {
		this.tableName=tableName;
		TableUtil.tryCreateTable(tableName, columnFamily, keys);//表不存在，则创建
	}
	/**
	 * 直接操作hbase的一个单元格
	 */
	public void put(RowKey rowKey,String columnFamily,String columnName,byte[] value){
		Put put = new Put(rowKey.toBytes());
		put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnName), value);
		Table table=TableUtil.getTable(tableName);
		try {
			table.put(put);
		} catch (IOException e) {
			throw new SimpleHBaseException("put error.", e);
		} finally {
			Util.close(table);
		}
	}
	public RowKey indexGet(RowKey rowKey,@Nullable Filter filter,
			@Nullable QueryExtInfo queryExtInfo,String qualifier){
		Table table=TableUtil.getTable(tableName);
		RowKey resultRowKey=null;
		try {
			Get get = new Get(rowKey.toBytes());
			get.setFilter(filter);
	
			// only query 1 version.
			if (queryExtInfo != null) {
				queryExtInfo.setMaxVersions(1);
			}
	
			if (queryExtInfo != null) {
				if (queryExtInfo.isMaxVersionSet()) {
					get.setMaxVersions(queryExtInfo.getMaxVersions());
				}
				if (queryExtInfo.isTimeRangeSet()) {
					get.setTimeRange(queryExtInfo.getMinStamp(),
							queryExtInfo.getMaxStamp());
				}
			}
			Result hbaseResult=table.get(get);
			
			Cell[] cells = hbaseResult.rawCells();
			if (cells == null || cells.length == 0) {
				return null;
			}
			String qualifierStr = null;
			
			for (Cell cell : cells) {
				/*byte[] familyBytes = CellUtil.cloneFamily(cell);
				familyStr = Bytes.toString(familyBytes);*/

				byte[] qualifierBytes = CellUtil.cloneQualifier(cell);
				qualifierStr = Bytes.toString(qualifierBytes);
				if(qualifierStr.equals(qualifier)){
					resultRowKey=new BytesRowKey(CellUtil.cloneValue(cell));
				}
			}
		} catch (IOException e) {
			throw new SimpleHBaseException("HbaseOriginService.indexGet. rowKey="
					+ rowKey, e);
		} finally {
			Util.close(table);
		}
		return resultRowKey;
	}
	public List<RowKey> indexScan(RowKey startRowKey, RowKey endRowKey, 
			@Nullable Filter filter, @Nullable QueryExtInfo queryExtInfo,String qualifier){
		Scan scan=new Scan();
		
		scan.setMaxVersions(1);
		
		long startIndex = 0L;
		long length = Long.MAX_VALUE;
		
		int cachingSize = 20;
		
		if (queryExtInfo != null) {
			if(queryExtInfo.isReversed()){//倒序
				scan.setStartRow(endRowKey.toBytes());
				scan.setStopRow(startRowKey.toBytes());
				//scan = constructScan(endRowKey, startRowKey, filter, queryExtInfo);
				scan.setReversed(true);
			}else{
				scan.setStartRow(startRowKey.toBytes());
				scan.setStopRow(endRowKey.toBytes());
				//scan = constructScan(startRowKey, endRowKey, filter, queryExtInfo);
			}
			if (queryExtInfo.isMaxVersionSet()) {
				scan.setMaxVersions(queryExtInfo.getMaxVersions());
			}
			if (queryExtInfo.isTimeRangeSet()) {
				try {
					scan.setTimeRange(queryExtInfo.getMinStamp(),
							queryExtInfo.getMaxStamp());
				} catch (IOException e) {
					// should never happen.
					throw new SimpleHBaseException("should never happen.", e);
				}
			}
			if (queryExtInfo.isLimitSet()) {
				startIndex = queryExtInfo.getStartIndex();
				length = queryExtInfo.getLength();
			}
			if (queryExtInfo != null && queryExtInfo.isLimitSet()) {
				long limitScanSize = queryExtInfo.getStartIndex()
						+ queryExtInfo.getLength();
				if (limitScanSize > Integer.MAX_VALUE) {
					cachingSize = Integer.MAX_VALUE;
				} else {
					cachingSize = (int) limitScanSize;
				}
			}
		}else{
			scan.setStartRow(startRowKey.toBytes());
			scan.setStopRow(endRowKey.toBytes());
			//scan = constructScan(startRowKey, endRowKey, filter, queryExtInfo);
		}
		scan.setFilter(filter);
		scan.setCaching(cachingSize);
		
		Table table=TableUtil.getTable(tableName);
		
		ResultScanner resultScanner = null;
		
		List<RowKey> resultList=new ArrayList<RowKey>();
		
		try {
			resultScanner = table.getScanner(scan);
			long ignoreCounter = startIndex;
			long resultCounter = 0L;
			Result result = null;
			while ((result = resultScanner.next()) != null) {
				if (ignoreCounter-- > 0) {
					continue;
				}
				//String familyStr = null;
				String qualifierStr = null;
				Cell[] cells = result.rawCells();
				if (cells == null || cells.length == 0) {
					continue;
				}
				byte[] hbaseValue={};
				for (Cell cell : cells) {
					/*byte[] familyBytes = CellUtil.cloneFamily(cell);
					familyStr = Bytes.toString(familyBytes);*/

					byte[] qualifierBytes = CellUtil.cloneQualifier(cell);
					qualifierStr = Bytes.toString(qualifierBytes);
					if(qualifierStr.equals(qualifier))
						hbaseValue = CellUtil.cloneValue(cell);
				}
				/*SimpleHbaseDOWithKeyResult<T> t = convertToSimpleHbaseDOWithKeyResult(
						result, type);*/
				if (hbaseValue != null && hbaseValue.length!=0) {
					resultList.add(new BytesRowKey(hbaseValue));
					if (++resultCounter >= length) {
						break;
					}
				}
			}
		} catch (IOException e) {
			throw new SimpleHBaseException(
					"HbaseOriginService.indexScan startRowKey=" + startRowKey
							+ " endRowKey=" + endRowKey, e);
		} finally {
			Util.close(resultScanner);
			Util.close(table);
		}
		return resultList;
	}
	public Map<String,Object> indexScanOfMap(RowKey startRowKey, RowKey endRowKey, 
			@Nullable Filter filter, @Nullable QueryExtInfo queryExtInfo,String qualifier){
		Scan scan=new Scan();
		
		scan.setMaxVersions(1);
		
		long startIndex = 0L;
		long length = Long.MAX_VALUE;
		
		int cachingSize = 20;
		
		if (queryExtInfo != null) {
			if(queryExtInfo.isReversed()){//倒序
				scan.setStartRow(endRowKey.toBytes());
				scan.setStopRow(startRowKey.toBytes());
				//scan = constructScan(endRowKey, startRowKey, filter, queryExtInfo);
				scan.setReversed(true);
			}else{
				scan.setStartRow(startRowKey.toBytes());
				scan.setStopRow(endRowKey.toBytes());
				//scan = constructScan(startRowKey, endRowKey, filter, queryExtInfo);
			}
			if (queryExtInfo.isMaxVersionSet()) {
				scan.setMaxVersions(queryExtInfo.getMaxVersions());
			}
			if (queryExtInfo.isTimeRangeSet()) {
				try {
					scan.setTimeRange(queryExtInfo.getMinStamp(),
							queryExtInfo.getMaxStamp());
				} catch (IOException e) {
					// should never happen.
					throw new SimpleHBaseException("should never happen.", e);
				}
			}
			if (queryExtInfo.isLimitSet()) {
				startIndex = queryExtInfo.getStartIndex();
				length = queryExtInfo.getLength();
			}
			if (queryExtInfo != null && queryExtInfo.isLimitSet()) {
				long limitScanSize = queryExtInfo.getStartIndex()
						+ queryExtInfo.getLength();
				if (limitScanSize > Integer.MAX_VALUE) {
					cachingSize = Integer.MAX_VALUE;
				} else {
					cachingSize = (int) limitScanSize;
				}
			}
		}else{
			scan.setStartRow(startRowKey.toBytes());
			scan.setStopRow(endRowKey.toBytes());
			//scan = constructScan(startRowKey, endRowKey, filter, queryExtInfo);
		}
		scan.setFilter(filter);
		scan.setCaching(cachingSize);
		
		Table table=TableUtil.getTable(tableName);
		
		ResultScanner resultScanner = null;
		
		List<RowKey> resultList=new ArrayList<RowKey>();
		byte[] bytes={};
		try {
			resultScanner = table.getScanner(scan);
			long ignoreCounter = startIndex;
			long resultCounter = 0L;
			Result result = null;
			while ((result = resultScanner.next()) != null) {
				if (ignoreCounter-- > 0) {
					continue;
				}
				//String familyStr = null;
				String qualifierStr = null;
				Cell[] cells = result.rawCells();
				if (cells == null || cells.length == 0) {
					continue;
				}
				byte[] hbaseValue={};
				for (Cell cell : cells) {
					/*byte[] familyBytes = CellUtil.cloneFamily(cell);
					familyStr = Bytes.toString(familyBytes);*/

					byte[] qualifierBytes = CellUtil.cloneQualifier(cell);
					qualifierStr = Bytes.toString(qualifierBytes);
					if(qualifierStr.equals(qualifier))
						hbaseValue = CellUtil.cloneValue(cell);
				}
				
				bytes = CellUtil.cloneRow(cells[0]);
				/*SimpleHbaseDOWithKeyResult<T> t = convertToSimpleHbaseDOWithKeyResult(
						result, type);*/
				if (hbaseValue != null && hbaseValue.length!=0) {
					resultList.add(new BytesRowKey(hbaseValue));
					if (++resultCounter >= length) {
						break;
					}
				}
			}
		} catch (IOException e) {
			throw new SimpleHBaseException(
					"HbaseOriginService.scan startRowKey=" + startRowKey
							+ " endRowKey=" + endRowKey, e);
		} finally {
			Util.close(resultScanner);
			Util.close(table);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rowKeyList", resultList);
		Byte[] byteObj=new Byte[bytes.length];
		for (int i = 0; i < byteObj.length; i++) {
			byteObj[i]=bytes[i];
		}
		map.put("endRowKey", byteObj);
		return map;
	}
	
	private static AggregationClient aggregationClient = AggregationClientUtil.getAggregationClient();
	/**
	 * 
	 * @Title: count
	 * @Description: 计数
	 * @param startRowKey
	 * @param endRowKey
	 * @param filter
	 * @return
	 * @throws SimpleHBaseException 
	 * @return long
	 * @throws
	 */
	public long count(RowKey startRowKey, RowKey endRowKey,@Nullable Filter filter) throws SimpleHBaseException {
		try {
			Scan scan = new Scan();
			scan.setStartRow(startRowKey.toBytes());
			scan.setStopRow(endRowKey.toBytes());

			int cachingSize = 20;

			/*if (simpleHbaseRuntimeSetting.isIntelligentScanSize()) {
				if (queryExtInfo != null && queryExtInfo.isLimitSet()) {
					long limitScanSize = queryExtInfo.getStartIndex()
							+ queryExtInfo.getLength();
					if (limitScanSize > Integer.MAX_VALUE) {
						cachingSize = Integer.MAX_VALUE;
					} else {
						cachingSize = (int) limitScanSize;
					}
				}
			}*/
			
			scan.setCaching(cachingSize);

			scan.setFilter(filter);

            LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
            
            
            // No need to close HTable,the AggregationClient close it.
            return aggregationClient.rowCount(TableNameUtil.getTableName(tableName),
                            columnInterpreter, scan);
        } catch (Throwable e) {
            throw new SimpleHBaseException(e);
        }
	}
}
