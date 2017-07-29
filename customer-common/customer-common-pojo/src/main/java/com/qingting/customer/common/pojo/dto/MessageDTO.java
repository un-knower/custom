package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;

public class MessageDTO {
	/**
	 * 消息id
	 */
	private Long id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 分类编号
	 */
	private String sortCode;
	/**
	 * 消息内容
	 */
	private String content;
	
	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="时间",example="[2017-01-01 12:00]",dataType="String")
	private Calendar createTime;
	/**
	 * 图片路径
	 */
	private String path;
	/**
	 * 详细ID
	 */
	private Integer detailId;
	/**
	 * 已读标志
	 */
	private boolean readFlag;
	/**
	 * 状态(已完成、已同意等)
	 */
	private String status;
	/**
	 * 消息rowkey
	 */
	private String rowKey;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public boolean isReadFlag() {
		return readFlag;
	}
	public void setReadFlag(boolean readFlag) {
		this.readFlag = readFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRowKey() {
		return rowKey;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}
}
