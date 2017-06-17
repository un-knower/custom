package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

/**
 * 
 * @ClassName: Extra
 * @Description: 保障和特权
 * @author zlf
 * @date 2017年5月15日 下午6:31:15
 *
 */
public class Extra {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	/**
	 * 数据的版本
	 */
	private final Byte version = 0;
	
	public String getRowKey() {
		return rowKey;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	public Byte getVersion() {
		return version;
	}
	
}
