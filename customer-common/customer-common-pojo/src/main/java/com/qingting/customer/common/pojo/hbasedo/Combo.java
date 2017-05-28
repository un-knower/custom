package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

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
