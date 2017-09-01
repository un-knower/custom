package com.qingting.customer.model.dto;


public class MyDTO {
	private String phone;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 头像路径
	 */
	private String path;
	/**
	 * 我的设备总数
	 */
	private Integer mineEquip;
	/**
	 * 关注的设备总数
	 */
	private Integer attentEquip;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getMineEquip() {
		return mineEquip;
	}
	public void setMineEquip(Integer mineEquip) {
		this.mineEquip = mineEquip;
	}
	public Integer getAttentEquip() {
		return attentEquip;
	}
	public void setAttentEquip(Integer attentEquip) {
		this.attentEquip = attentEquip;
	}
	
}
