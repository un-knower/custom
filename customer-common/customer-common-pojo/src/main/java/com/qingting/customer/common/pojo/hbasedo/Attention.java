package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.hadoop.hbase.util.Bytes;
/**
 * 
 * @ClassName: Attention
 * @Description: 用户关注
 * @author zlf
 * @date 2017年5月2日 下午4:40:27
 *
 */
public class Attention {
	

	/**
	 * ID
	 */
	private Integer id;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 设备编号
	 */
	private String equipCode;
	/**
	 * 状态(0:待审核 1:已通过 2:已拒绝)
	 */
	private byte status;
	/**
	 * 是否置顶
	 */
	private Boolean isTop;
	/**
	 * 时间
	 */
	private Calendar createTime;
	
	
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
	public String getEquipCode() {
		return equipCode;
	}
	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Boolean getIsTop() {
		return isTop;
	}
	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Attention [id=" + id + ", userId=" + userId + ", equipCode=" + equipCode + ", status=" + status
				+ ", isTop=" + isTop + ", createTime=" + createTime + "]";
	}
	
	
	
	
}
