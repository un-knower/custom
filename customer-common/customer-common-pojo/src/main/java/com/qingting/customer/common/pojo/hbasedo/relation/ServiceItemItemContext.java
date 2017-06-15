package com.qingting.customer.common.pojo.hbasedo.relation;

import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

public class ServiceItemItemContext {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 项目ID
	 */
	private Integer projectId;
	/**
	 * 设备ID
	 */
	private Integer equipId;
	/**
	 * 服务项ID
	 */
	private Integer serviceItemId;
	
	/**
	 * 服务内容ID
	 */
	private Integer itemContextId;
	/**
	 * 上次服务时间
	 */
	private Calendar lastTime;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getEquipId() {
		return equipId;
	}
	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}
	public Integer getServiceItemId() {
		return serviceItemId;
	}
	public void setServiceItemId(Integer serviceItemId) {
		this.serviceItemId = serviceItemId;
	}
	public Integer getItemContextId() {
		return itemContextId;
	}
	public void setItemContextId(Integer itemContextId) {
		this.itemContextId = itemContextId;
	}
	public Calendar getLastTime() {
		return lastTime;
	}
	public void setLastTime(Calendar lastTime) {
		this.lastTime = lastTime;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
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
		this.userId=Bytes.toInt(dest);
		System.arraycopy(rowkey, 0, dest, 0, 4);//4个字节,projectId
		this.projectId=Bytes.toInt(dest);
		System.arraycopy(rowkey, 0, dest, 0, 4);//4个字节,equipId
		this.equipId=Bytes.toInt(dest);
		System.arraycopy(rowkey, 0, dest, 0, 4);//4个字节,serviceItemId
		this.serviceItemId=Bytes.toInt(dest);
		
	}
	
}
