package com.qingting.customer.common.pojo.hbasedo.relation;

import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

public class ComboConfig {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 套餐ID外键
	 */
	private Integer comboId;
	/**
	 * 配置ID外键
	 */
	private Integer configId;
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
	public Integer getComboId() {
		return comboId;
	}
	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}
	public Integer getConfigId() {
		return configId;
	}
	public void setConfigId(Integer configId) {
		this.configId = configId;
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
		System.arraycopy(rowkey, 0, dest, 0, 4);//前4个字节,id
		this.id=Bytes.toInt(dest);
	}
	
}
