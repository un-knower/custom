package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import com.alibaba.fastjson.annotation.JSONField;
import com.qingting.customer.common.pojo.common.PersistentObject;

import io.swagger.annotations.ApiModelProperty;

public class Message extends PersistentObject{

	private static final long serialVersionUID = 3792614722479457227L;
	
	
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 对应的消息触发对象ID
	 */
	private Integer detailId;
	/**
	 * 用户Id
	 */
	private Integer userId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 消息内容
	 */
	private String content;
	
	/**
	 * 消息显示的图片路径
	 */
	private String imageUrl;
	
	/**
	 * 分类编号
	 */
	private String sortCode;
	
	/**
	 * 已读标志
	 */
	private Boolean readFlag;
	
	/**
	 * 状态(已完成、已同意等)
	 */
	private String status;
	
	/**
	 * 创建时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="时间",example="2017-01-01 12:00:00",dataType="String")
	private Calendar createTime;

	/**
	 * 有的消息需要额外传一些参数
	 */
	private String strParam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public Boolean getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Boolean readFlag) {
		this.readFlag = readFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", detailId=" + detailId + ", userId=" + userId + ", title=" + title + ", content="
				+ content + ", imageUrl=" + imageUrl + ", sortCode=" + sortCode + ", readFlag=" + readFlag + ", status="
				+ status + ", createTime=" + createTime + ", strParam=" + strParam + "]";
	}

	
	
}
