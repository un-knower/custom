package com.qingting.customer.common.pojo.dto;

import java.io.Serializable;

public class FilterGroupDTO implements Serializable{
	
	private static final long serialVersionUID = 7778388013984015614L;
	
	private Integer id;
	private String oneFilterName;
	private String twoFilterName;
	private String threeFilterName;
	private String fourFilterName;
	private String fiveFilterName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOneFilterName() {
		return oneFilterName;
	}
	public void setOneFilterName(String oneFilterName) {
		this.oneFilterName = oneFilterName;
	}
	public String getTwoFilterName() {
		return twoFilterName;
	}
	public void setTwoFilterName(String twoFilterName) {
		this.twoFilterName = twoFilterName;
	}
	public String getThreeFilterName() {
		return threeFilterName;
	}
	public void setThreeFilterName(String threeFilterName) {
		this.threeFilterName = threeFilterName;
	}
	public String getFourFilterName() {
		return fourFilterName;
	}
	public void setFourFilterName(String fourFilterName) {
		this.fourFilterName = fourFilterName;
	}
	public String getFiveFilterName() {
		return fiveFilterName;
	}
	public void setFiveFilterName(String fiveFilterName) {
		this.fiveFilterName = fiveFilterName;
	}
	
	
}
