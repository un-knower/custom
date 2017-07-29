package com.qingting.customer.common.pojo.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


/**
 * 分页包含列表list属性基类
 * 
 * @author Joe
 */
public class Pagination<T> extends PaginationSupport implements Serializable {
	
	private static final long serialVersionUID = 7002501955628078021L;
	/** 当前页的数据 */
	private List<T> list;
	/**
	 * 上一次查询的页码
	 */
	private int lastPageNo=1;
	/**
	 * 上次查询的结束行键
	 */
	private Byte[] endRowKey;
	/**
	 * 返回的数据实际条数
	 */
	private int realityCount;
	
	
	public Pagination() {
	
	}


	public Pagination(int pageNo, int pageSize) {
		super(pageNo, pageSize);
	}
	
	public Pagination(int pageNo, int pageSize,Byte[] endRowKey) {
		super(pageNo, pageSize);
		this.endRowKey=endRowKey;
	}
	
	
	
	public int getLastPageNo() {
		return lastPageNo;
	}


	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}


	public Byte[] getEndRowKey() {
		return endRowKey;
	}
	

	public void setEndRowKey(Byte[] endRowKey) {
		this.endRowKey = endRowKey;
	}


	public int getRealityCount() {
		return realityCount;
	}


	public void setRealityCount(int realityCount) {
		this.realityCount = realityCount;
	}


	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * 
	 * @param list
	 */
	public void setList(List<T> list) {
		this.list = list;
	}
	
	/**
	 * 
	 * @Title: convertEndRowKey
	 * @Description: 获取结束行键
	 * @return 
	 * @return byte[]
	 * @throws
	 */
	public byte[] convertFromEndRowKey(){
		byte[] bytes=new byte[endRowKey.length];
		for (int i=0 ;i<endRowKey.length;i++ ) {
			bytes[i]=endRowKey[i];
		}
		return bytes;
	}
	public void convertToEndRowKey(byte[] bytes){
		Byte[] endRowKey=new Byte[bytes.length];
		for(int i=0;i<bytes.length;i++){
			endRowKey[i]=bytes[i];
		}
		this.endRowKey=endRowKey;
	}

	@Override
	public String toString() {
		return "Pagination [list=" + list + ", lastPageNo=" + lastPageNo + ", endRowKey=" + Arrays.toString(endRowKey)
				+ ", realityCount=" + realityCount + "]";
	}
	
	
}
