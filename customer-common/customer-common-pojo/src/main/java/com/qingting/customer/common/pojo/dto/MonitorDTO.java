package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;


public class MonitorDTO {
	/**
	 * 用户名字
	 */
	private String userName;
	/**
	 * 日期数据
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value="时间",example="[2017-01-01 12:00:00]",dataType="String")
	private List<Calendar> secondDates;
	/**
	 * 原水数据
	 */
	private List<Float> rawDatas;
	/**
	 * 净水数据
	 */
	private List<Float> purDatas;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Calendar> getSecondDates() {
		return secondDates;
	}
	public void setSecondDates(List<Calendar> secondDates) {
		this.secondDates = secondDates;
	}
	public List<Float> getRawDatas() {
		return rawDatas;
	}
	public void setRawDatas(List<Float> rawDatas) {
		this.rawDatas = rawDatas;
	}
	public List<Float> getPurDatas() {
		return purDatas;
	}
	public void setPurDatas(List<Float> purDatas) {
		this.purDatas = purDatas;
	}
	
	
	
	
}
