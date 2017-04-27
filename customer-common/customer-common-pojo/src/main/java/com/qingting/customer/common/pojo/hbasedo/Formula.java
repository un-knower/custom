package com.qingting.customer.common.pojo.hbasedo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Formula {
	/**
	 * d值计算公式
	 */
	private String d;
	/**
	 * w值计算公司
	 */
	private String w;
	
	/**
	 * 数据的版本，更新时用，监测数据只需要一个版本
	 */
	private final Byte version = 0;
	
	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
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
