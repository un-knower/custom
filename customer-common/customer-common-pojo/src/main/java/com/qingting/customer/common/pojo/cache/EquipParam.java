package com.qingting.customer.common.pojo.cache;

public class EquipParam {
	/**
	 * 浊度
	 */
	private Float turbidity;
	/**
	 * 余氯
	 */
	private Float chlorine;
	/**
	 * 第一级滤芯公式
	 */
	private String oneFormula;
	/**
	 * 第二级滤芯公式
	 */
	private String twoFormula;
	/**
	 * 第三级滤芯公式
	 */
	private String threeFormula;
	/**
	 * 第四级滤芯公式
	 */
	private String fourFormula;
	/**
	 * 第五级滤芯公式
	 */
	private String fiveFormula;
	/**
	 * 微生物公式
	 */
	private String microFormula;
	
	public Float getTurbidity() {
		return turbidity;
	}
	public void setTurbidity(Float turbidity) {
		this.turbidity = turbidity;
	}
	public Float getChlorine() {
		return chlorine;
	}
	public void setChlorine(Float chlorine) {
		this.chlorine = chlorine;
	}
	public String getOneFormula() {
		return oneFormula;
	}
	public void setOneFormula(String oneFormula) {
		this.oneFormula = oneFormula;
	}
	public String getTwoFormula() {
		return twoFormula;
	}
	public void setTwoFormula(String twoFormula) {
		this.twoFormula = twoFormula;
	}
	public String getThreeFormula() {
		return threeFormula;
	}
	public void setThreeFormula(String threeFormula) {
		this.threeFormula = threeFormula;
	}
	public String getFourFormula() {
		return fourFormula;
	}
	public void setFourFormula(String fourFormula) {
		this.fourFormula = fourFormula;
	}
	public String getFiveFormula() {
		return fiveFormula;
	}
	public void setFiveFormula(String fiveFormula) {
		this.fiveFormula = fiveFormula;
	}
	public String getMicroFormula() {
		return microFormula;
	}
	public void setMicroFormula(String microFormula) {
		this.microFormula = microFormula;
	}
	@Override
	public String toString() {
		return "RedisEquipParam [turbidity=" + turbidity + ", chlorine=" + chlorine + ", oneFormula=" + oneFormula
				+ ", twoFormula=" + twoFormula + ", threeFormula=" + threeFormula + ", fourFormula=" + fourFormula
				+ ", fiveFormula=" + fiveFormula + ", microFormula=" + microFormula + "]";
	}
	
	
}
