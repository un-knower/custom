package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;

public class MessageDTO {
	/**
	 * 消息id
	 */
	private Integer id;
	/**
	 * 分类名称
	 */
	private String sortName;
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
	 * 用户Id
	 */
	private Integer userId;
	/**
	 * 已读标志
	 */
	private boolean readFlag;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public boolean isReadFlag() {
		return readFlag;
	}
	public void setReadFlag(boolean readFlag) {
		this.readFlag = readFlag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
