package com.qingting.customer.model.dto;

import java.util.Calendar;

public class PlanSimpleDTO {
	
	/**
	 * 这个服务类型的图片
	 */
	private String image;
	/**
	 * 服务名字、标题
	 */
	private String serHead;
	private String serContent;//服务内容
	private Calendar time;     //服务时间
	private String adress;  //地址
	/**
	 * 下次服务编号
	 */
	private String serCode;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSerHead() {
		return serHead;
	}
	public void setSerHead(String serHead) {
		this.serHead = serHead;
	}
	public String getSerContent() {
		return serContent;
	}
	public void setSerContent(String serContent) {
		this.serContent = serContent;
	}
	public Calendar getTime() {
		return time;
	}
	public void setTime(Calendar time) {
		this.time = time;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getSerCode() {
		return serCode;
	}
	public void setSerCode(String serCode) {
		this.serCode = serCode;
	}
	
	
	
	
}
