package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;
import java.util.List;

public class HisServiceDTO {
	/**
	 * 服务编号
	 */
	private String serCode;
	/**
	 * 员工编号
	 */
	private String empCode;
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 头像
	 */
	private String portrait;
	/**
	 * 设备名称
	 */
	private String equipName;
	/**
	 * 标题
	 */
	private String serHead;
	private Calendar notice;   //通知时间
	private String serContent;//服务内容
	private Integer rank;    //评价星星
	private String status;//服务状态
	private List<EvaDTO> evaContent;  //评价内容
	private Calendar time;     //服务时间
	private String adress;  //地址
	private List<String> images; //服务照片
	private boolean evaFlag; //评价标志
	
	public String getSerCode() {
		return serCode;
	}
	public void setSerCode(String serCode) {
		this.serCode = serCode;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getSerHead() {
		return serHead;
	}
	public void setSerHead(String serHead) {
		this.serHead = serHead;
	}
	public Calendar getNotice() {
		return notice;
	}
	public void setNotice(Calendar notice) {
		this.notice = notice;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<EvaDTO> getEvaContent() {
		return evaContent;
	}
	public void setEvaContent(List<EvaDTO> evaContent) {
		this.evaContent = evaContent;
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
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public boolean isEvaFlag() {
		return evaFlag;
	}
	public void setEvaFlag(boolean evaFlag) {
		this.evaFlag = evaFlag;
	}
	
	
}
