package com.qingting.customer.model;

import java.util.Calendar;


public class ComParam {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 采集频率：s/次
	 */
	private Byte freq;
	/**
	 * 原水第一次预警值
	 */
	private Integer rawFirWarn;
	/**
	 * 原水第二次预警值
	 */
	private Integer rawSecWarn;
	/**
	 * 原水第三次预警值
	 */
	private Integer rawThrWarn;
	/**
	 * 原水第四次预警值
	 */
	private Integer rawFouWarn;

	/**
	 * 标题
	 */
	private String title;
	/**
	 * 开始时间
	 */
	private Calendar startTime;
	/**
	 * 结束时间
	 */
	private Calendar endTime;
	/**
	 * 净水第一次预警值
	 */
	private Integer purFirWarn;
	/**
	 * 净水第二次预警值
	 */
	private Integer purSecWarn;
	/**
	 * 状态：true失能
	 */
	private Boolean enable;
	/**
	 * 创建时间
	 */
	private Calendar calendar;
	/**
	 * 数据的版本，更新时用，只需要一个版本
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

	public Byte getFreq() {
		return freq;
	}

	public void setFreq(Byte freq) {
		this.freq = freq;
	}

	public Integer getRawFirWarn() {
		return rawFirWarn;
	}

	public void setRawFirWarn(Integer rawFirWarn) {
		this.rawFirWarn = rawFirWarn;
	}

	public Integer getRawSecWarn() {
		return rawSecWarn;
	}

	public void setRawSecWarn(Integer rawSecWarn) {
		this.rawSecWarn = rawSecWarn;
	}

	public Integer getRawThrWarn() {
		return rawThrWarn;
	}

	public void setRawThrWarn(Integer rawThrWarn) {
		this.rawThrWarn = rawThrWarn;
	}

	public Integer getRawFouWarn() {
		return rawFouWarn;
	}

	public void setRawFouWarn(Integer rawFouWarn) {
		this.rawFouWarn = rawFouWarn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public Integer getPurFirWarn() {
		return purFirWarn;
	}

	public void setPurFirWarn(Integer purFirWarn) {
		this.purFirWarn = purFirWarn;
	}

	public Integer getPurSecWarn() {
		return purSecWarn;
	}

	public void setPurSecWarn(Integer purSecWarn) {
		this.purSecWarn = purSecWarn;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
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
