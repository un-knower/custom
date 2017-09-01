package com.qingting.customer.model.common;

public enum FormulaVariate {
	/**
	 * 上次的计算结果
	 */
	LAST("last"),
	/**
	 * 最新的浊度值
	 */
	TB("Tb"),
	/**
	 * 上次的流量值
	 */
	QL("Q`"),
	/**
	 * 本次的流量值
	 */
	Q("Q"),
	/**
	 * 本次原水TDS
	 */
	TR("Tr"),
	/**
	 * 本次净水TDS
	 */
	TP("Tp"),
	/**
	 * 最新的余氯值
	 */
	CL("Cl"),
	/**
	 * 上次采集的时间
	 */
	TIMEL("t`"),
	/**
	 * 本次采集的时间
	 */
	TIME("t"),
	/**
	 * 本次采集的温度值
	 */
	TEMP("T")
	;
	
	private String value;
	
	private FormulaVariate(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
