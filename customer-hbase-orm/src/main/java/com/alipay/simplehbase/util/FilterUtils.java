package com.alipay.simplehbase.util;

import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.BitComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;

public class FilterUtils {
	
	
	/**
	 * 必须包含以str结尾的行键.
	 */
	public static Filter getSuffixFilter(String str){
		return new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*"+str+"$"));
	}
	public static Filter getSuffixFilter(Integer value){
		return new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*"+new String(Bytes.toBytes(value))+"$"));
	}
	/**
	 * 包含str的行键
	 */
	public static Filter getContainFilter(String str){
		return new RowFilter(CompareOp.EQUAL,new SubstringComparator(str));
	}
	public static Filter getContainFilter(Integer value){
		return new RowFilter(CompareOp.EQUAL,new SubstringComparator(new String(Bytes.toBytes(value))));
	}
	/**
	 * 不包含str的行键
	 */
	public static Filter getNotContainFilter(String str){
		return new RowFilter(CompareOp.NOT_EQUAL,new SubstringComparator(str));
	}
	/**
	 * 
	 * @Title: getPrefixFilter
	 * @Description: 以str开头的行键
	 * @param str
	 * @return 
	 * @return Filter
	 * @throws
	 */
	public static Filter getPrefixFilter(String str){
		return new RowFilter(CompareOp.EQUAL,new BinaryPrefixComparator(str.getBytes()));
	}
	public static Filter getPrefixFilter(Integer value){
		return new RowFilter(CompareOp.EQUAL,new BinaryPrefixComparator(Bytes.toBytes(value)));
	}
	
	public static Filter getValueFilter(String value){
		return new ValueFilter(CompareOp.EQUAL, new SubstringComparator(value)); // OK 筛选某个（值的条件满足的）特定的单元格  
	}
	
	public static Filter getSingleColumnValueFilter(String family,String qualifier,byte[] value){
		SingleColumnValueFilter scvf = new SingleColumnValueFilter(  
		        Bytes.toBytes(family),   
		        Bytes.toBytes(qualifier),   
		        CompareOp.EQUAL,   
		        new BinaryComparator(value));  
		scvf.setFilterIfMissing(true);//true 如果没有找到该列，则整个行将被跳过。
		scvf.setLatestVersionOnly(true); 
		return scvf;
	}
}
