package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;

public class HisSerSimpleDTO {
	
	/**
	 * 这个服务类型的图片
	 */
	private String image;
	/**
	 * 标题
	 */
	private String serHead;
	private String serContent;//服务内容
	private Integer rank;    //评价星星
	private Calendar time;     //服务时间
	private String adress;  //地址
	private boolean evaFlag; //评价标志
	/**
	 * 服务编号
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
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
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
	public boolean isEvaFlag() {
		return evaFlag;
	}
	public void setEvaFlag(boolean evaFlag) {
		this.evaFlag = evaFlag;
	}
	public String getSerCode() {
		return serCode;
	}
	public void setSerCode(String serCode) {
		this.serCode = serCode;
	}
	
}
