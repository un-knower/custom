package com.qingting.customer.model.hbasedo;

import java.util.Calendar;


/**
 * 
 * @ClassName: Combo
 * @Description: 用户套餐
 * @author zlf
 * @date 2017年5月12日 下午2:46:23
 *
 */
public class Combo {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 套餐名称：(基础版、标准版、专业版、豪华版、至尊版)
	 */
	private String name;
	/**
	 * 服务等级
	 */
	private Integer serviceLevel;
	/**
	 * 配置(可能包含净水器、滤芯、小清渟、水龙头等)
	 */
	//private List<Config> configs; 
	/**
	 * 保障和特权
	 */
	//private List<Extra> extras;
	/**
	 * 创建时间
	 */
	private Calendar calendar;
	/**
	 * 数据的版本
	 */
	private final Byte version = 0;
	
	public String getRowKey() {
		return rowKey;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getServiceLevel() {
		return serviceLevel;
	}
	public void setServiceLevel(Integer serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public Byte getVersion() {
		return version;
	}
	
}
