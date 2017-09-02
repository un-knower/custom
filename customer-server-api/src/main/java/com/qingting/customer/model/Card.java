package com.qingting.customer.model;

import java.util.Calendar;

import com.smart.mvc.model.PersistentObject;

public class Card extends PersistentObject{
	
	private static final long serialVersionUID = -5812940573316506470L;
	
	private Integer id;
	/**
	 * 卡号
	 */
	private String number;
	/**
	 * 运营商分类
	 */
	private Byte operatorSort;
	/**
	 * 创建时间
	 */
	private Calendar createTime;
	
	
	
	public Card() {
		super();
	}

	public Card(Byte operatorSort,String number) {
		super();
		this.number = number;
		this.operatorSort = operatorSort;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Byte getOperatorSort() {
		return operatorSort;
	}

	public void setOperatorSort(Byte operatorSort) {
		this.operatorSort = operatorSort;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	
	
	
	
}
