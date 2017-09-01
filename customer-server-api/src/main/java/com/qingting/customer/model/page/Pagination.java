package com.qingting.customer.model.page;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 分页包含列表list属性基类
 * 
 * @author Joe
 */
public class Pagination<T> extends PaginationSupport implements Serializable {
	
	private static final long serialVersionUID = 7002501955628078021L;
	/** 当前页的数据 */
	private List<T> list;
	
	Map<String,Object> map;
	
	public Pagination() {
	
	}
	
	public Pagination(int pageNo, int pageSize) {
		super(pageNo, pageSize);
	}

	/*
	public int getLastPageNo() {
		return lastPageNo;
	}

	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}

	public int getRealityCount() {
		return RealityCount;
	}

	public void setRealityCount(int realityCount) {
		RealityCount = realityCount;
	}*/
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
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

	@Override
	public String toString() {
		return "Pagination [list=" + list + ", map=" + map + "]";
	}
	
}
