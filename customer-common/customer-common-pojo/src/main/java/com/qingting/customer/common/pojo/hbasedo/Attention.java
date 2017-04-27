package com.qingting.customer.common.pojo.hbasedo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Attention {
	/**
	 * 项目RowKey
	 */
	private Byte[] bytes;
	
	/**
	 * 数据的版本，更新时用，只需要一个版本
	 */
	private final Byte version = 0;

	public Byte[] getBytes() {
		return bytes;
	}

	public void setBytes(Byte[] bytes) {
		this.bytes = bytes;
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
}
