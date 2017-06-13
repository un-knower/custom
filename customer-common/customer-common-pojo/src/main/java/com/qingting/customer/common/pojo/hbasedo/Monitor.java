package com.qingting.customer.common.pojo.hbasedo;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.hadoop.hbase.util.Bytes;


public class Monitor implements Serializable{

	private static final long serialVersionUID = -3476260854075534540L;
	
	private String rowKey;
	/**
	 * ID
	 */
	private Long id;
	/**
	 * 调试用数据字段
	 */
	private String data;
	/**
	 * 调试用时间字段
	 */
	private String date;
	/**
	 * 原水TDS值
	 */
	private Float rawTds;

	/**
	 * 净水TDS值
	 */
	private Float purTds;

	/**
	 * 温度值
	 */
	private Float temp;

	/**
	 * 湿度值
	 */
	private Float humidity;

	/**
	 * 流量值
	 */
	private Float flow;

	/**
	 * 漏水状态开关：true-漏水、false-无漏水
	 */
	private Boolean leak;

	/**
	 * d值
	 */
	private Float d;

	/**
	 * w值
	 */
	private Float w;
	
	/**
	 * 设备Id
	 */
	private Integer equipId;

	/**
	 * 创建时间
	 */
	private Calendar calendar;

	/**
	 * 数据的版本，更新时用，监测数据只需要一个版本
	 */
	private final Byte version = 0;

	
	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Float getRawTds() {
		return rawTds;
	}

	public void setRawTds(Float rawTds) {
		this.rawTds = rawTds;
	}

	public Float getPurTds() {
		return purTds;
	}

	public void setPurTds(Float purTds) {
		this.purTds = purTds;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getHumidity() {
		return humidity;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	public Float getFlow() {
		return flow;
	}

	public void setFlow(Float flow) {
		this.flow = flow;
	}

	public Boolean getLeak() {
		return leak;
	}

	public void setLeak(Boolean leak) {
		this.leak = leak;
	}

	public Float getD() {
		return d;
	}

	public void setD(Float d) {
		this.d = d;
	}

	public Float getW() {
		return w;
	}

	public void setW(Float w) {
		this.w = w;
	}

	public Integer getEquipId() {
		return equipId;
	}

	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
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

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	/**
	 * 
	 * @Title: setContentOfRowKey
	 * @Description: 根据查询的rowkey设置对应rowkey中包含的字段
	 * @param rowkey
	 * @return void
	 * @throws
	 */
	public void setContentOfRowKey(byte[] rowkey){
		this.rowKey=new String(rowkey);
		if(rowkey.length<8){
			throw new RuntimeException(this.getClass()+"rowkey长度有误，请检查程序.");
		}
		byte[] dest=new byte[4];
		System.arraycopy(rowkey, 0, dest, 0, 4);//前4个字节,所属设备id
		this.equipId=Bytes.toInt(dest);
		//System.arraycopy(rowkey, rowkey.length-4, dest, 0, 4);//最后4个字节,设备id
		//this.id=Bytes.toInt(dest);
	}
}
