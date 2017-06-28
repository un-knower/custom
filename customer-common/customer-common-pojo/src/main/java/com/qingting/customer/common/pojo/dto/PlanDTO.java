package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;
import java.util.List;

public class PlanDTO {
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 头像
	 */
	private String portrait;
	private String serHead;//服务名字
	private Calendar notice;//通知时间
	private String status;//服务状态
	private String warnContent; //预警内容
	/**
	 * 设备编号
	 */
	private String equipCode;
	/**
	 * 设备名称
	 */
	private String equipName;
	private String remark;  //备注
	private String adress;  //地址
	private List<String> images;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWarnContent() {
		return warnContent;
	}
	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
	}
	public String getEquipCode() {
		return equipCode;
	}
	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	
}
