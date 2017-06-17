package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;


/**
 * @ClassName: Warn
 * @Description: 预警信息
 * @author zlf
 * @date 2017年6月17日 下午5:35:04
 *
 */
public class Warn {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 预警类型ID
	 */
	private Integer warnSortId;
	
	/**
	 * 设备ID
	 */
	private Integer equipId;
	/**
	 * 状态
	 */
	private String status;
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
	public Integer getWarnSortId() {
		return warnSortId;
	}
	public void setWarnSortId(Integer warnSortId) {
		this.warnSortId = warnSortId;
	}
	public Integer getEquipId() {
		return equipId;
	}
	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		System.arraycopy(rowkey, 0, dest, 0, 4);//前4个字节,所属用户id
		this.equipId=Bytes.toInt(dest);
		System.arraycopy(rowkey, rowkey.length-4, dest, 0, 4);//最后4个字节,项目id
		this.id=Bytes.toInt(dest);
	}
}
