package com.alipay.simplehbase.util;

import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;

public class FilterUtils {
	/**
	 * 
	 * @Title: getSuffixFilter
	 * @Description: 以str结尾的行键
	 * @param str
	 * @return 
	 * @return Filter
	 * @throws
	 */
	public static Filter getSuffixFilter(String str){
		return new RowFilter(CompareOp.EQUAL,new RegexStringComparator(".*"+str+"$"));
	}
	/**
	 * 
	 * @Title: getContainFilter
	 * @Description: 包含str的行键
	 * @param str
	 * @return 
	 * @return Filter
	 * @throws
	 */
	public static Filter getContainFilter(String str){
		return new RowFilter(CompareOp.EQUAL,new SubstringComparator(str));
	}
	public static Filter getContainFilter(Integer value){
		return new RowFilter(CompareOp.EQUAL,new SubstringComparator(new String(Bytes.toBytes(value))));
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
	
}
