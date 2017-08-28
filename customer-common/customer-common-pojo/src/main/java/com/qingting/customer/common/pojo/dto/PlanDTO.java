package com.qingting.customer.common.pojo.dto;

import java.util.Calendar;
import java.util.List;

public class PlanDTO {
	
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
	
	
	
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 头像
	 */
	private String portrait;
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
	private List<String> images;
	
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
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	
	
	
}
