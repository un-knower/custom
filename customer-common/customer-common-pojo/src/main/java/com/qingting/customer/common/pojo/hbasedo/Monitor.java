package com.qingting.customer.common.pojo.hbasedo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
	private Byte temp;

	/**
	 * 湿度值
	 */
	private Byte humidity;

	/**
	 * 流量值
	 */
	private Long flow;

	/**
	 * 漏水状态开关：true-漏水、false-无漏水
	 */
	private Boolean leak;
	
	/**
	 * 电磁阀输出状态 true:电磁阀供电 false:电池阀不供电
	 */
	private Boolean magnetic;
	
	/**
	 * 输出继电器 true:闭合 false:断开
	 */
	private Boolean outRelay;
	
	/**
	 * 电源继电器 true:有输出 false:无输出
	 */
	private Boolean powerRelay;
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
	 * 设备编号
	 */
	private String equipCode;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	/**
	 * 时间DTO
	 */
	private String time;
	

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

	public Byte getTemp() {
		return temp;
	}

	public void setTemp(Byte temp) {
		this.temp = temp;
	}

	public Byte getHumidity() {
		return humidity;
	}

	public void setHumidity(Byte humidity) {
		this.humidity = humidity;
	}

	public Long getFlow() {
		return flow;
	}

	public void setFlow(Long flow) {
		this.flow = flow;
	}

	public Boolean getLeak() {
		return leak;
	}

	public void setLeak(Boolean leak) {
		this.leak = leak;
	}

	public Boolean getMagnetic() {
		return magnetic;
	}

	public void setMagnetic(Boolean magnetic) {
		this.magnetic = magnetic;
	}

	public Boolean getOutRelay() {
		return outRelay;
	}

	public void setOutRelay(Boolean outRelay) {
		this.outRelay = outRelay;
	}

	public Boolean getPowerRelay() {
		return powerRelay;
	}

	public void setPowerRelay(Boolean powerRelay) {
		this.powerRelay = powerRelay;
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

	public String getEquipCode() {
		return equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}*/
	
	
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

	@Override
	public String toString() {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		return "Monitor [rowKey=" + rowKey + ", id=" + id + ", rawTds=" + rawTds + ", purTds=" + purTds + ", temp="
				+ temp + ", humidity=" + humidity + ", flow=" + flow + ", leak=" + leak + ", magnetic=" + magnetic
				+ ", outRelay=" + outRelay + ", powerRelay=" + powerRelay + ", d=" + d + ", w=" + w + ", equipId="
				+ equipId + ", equipCode=" + equipCode + ", createTime=" + format.format(createTime.getTime()) + "]";
	}

	/*@Override
	public String toString() {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		
		return "Monitor [rowKey=" + rowKey + ", id=" + id + ", data=" + data + ", date=" + date + ", rawTds=" + rawTds
				+ ", purTds=" + purTds + ", temp=" + temp + ", humidity=" + humidity + ", flow=" + flow + ", leak="
				+ leak + ", magnetic=" + magnetic + ", outRelay=" + outRelay + ", powerRelay=" + powerRelay + ", d=" + d
				+ ", w=" + w + ", equipId=" + equipId + ", equipCode=" + equipCode + ", createTime=" + format.format(createTime.getTime())
				+ ", version=" + version + "]";
	}*/
	
	
}
