package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;

public class MessageDTO {
	/**
	 * 分类名称
	 */
	private String sortName;
	/**
	 * 分类编号
	 */
	private String sortCode;
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
	 * 用户Id
	 */
	private Integer userId;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
