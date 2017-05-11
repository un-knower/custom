package com.qingting.customer.common.pojo.hbasedo;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

public class Message implements Serializable{

	private static final long serialVersionUID = 3792614722479457227L;
	private String rowKey;
	/**
	 * id
	 */
	private Long id;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * IP地址
	 */
	private String ipAddr;
	/**
	 * 分类id
	 */
	private Integer messageSortId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Integer getMessageSortId() {
		return messageSortId;
	}

	public void setMessageSortId(Integer messageSortId) {
		this.messageSortId = messageSortId;
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
		byte[] dest1=new byte[8];
		System.arraycopy(rowkey, 0, dest1, 0, 8);//前8个字节,phone
		this.phone=new String(dest1);
		byte[] dest2=new byte[4];
		System.arraycopy(rowkey, 8, dest2, 0, 4);//4个字节,ip
		this.ipAddr=new String(dest2);
		//byte[] dest3=new byte[8];
		//System.arraycopy(rowkey, 12, dest3, 0, 8);//4个字节,sort
		//this.messageSortId=Bytes.toInt(dest3);
		byte[] dest4=new byte[4];
		System.arraycopy(rowkey, 20, dest4, 0, 4);//4个字节,sort
		this.messageSortId=Bytes.toInt(dest4);
	}
	public String convertIp(byte[] ip){
		StringBuilder buf=null;
		for(int i=0;i<ip.length;i++){
			buf = new StringBuilder();
			buf.append(String.valueOf(ip[i]));
			if(i<ip.length)
				buf.append(".");
		}
		return buf.toString();
	}
}
