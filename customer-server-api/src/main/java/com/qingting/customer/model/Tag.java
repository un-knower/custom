package com.qingting.customer.model;

import java.util.Calendar;
/**
 * 
 * @ClassName: Tag
 * @Description: 评价标签
 * @author zlf
 * @date 2017年6月15日 下午5:34:06
 *
 */
public class Tag {
	/**
	 * rowkey
	 */
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 等级
	 */
	private Integer rank;
	/**
	 * 标签名字
	 */
	private String tagName;
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
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
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
