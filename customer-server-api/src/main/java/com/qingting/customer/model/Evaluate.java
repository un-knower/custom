package com.qingting.customer.model;

import java.util.Calendar;

/**
 * 
 * @ClassName: Evaluate
 * @Description: 用户评价
 * @author zlf
 * @date 2017年6月15日 下午4:20:26
 *
 */
public class Evaluate {
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
	 * 评价内容
	 */
	private String content;
	/**
	 * 服务ID
	 */
	private Integer serviceId;
	/**
	 * 用户ID
	 */
	private Integer userId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
