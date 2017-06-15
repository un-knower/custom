package com.qingting.customer.common.pojo.hbasedo;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.hadoop.hbase.util.Bytes;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6610579266435676798L;
	
	public static final String MAX_ROWKEY=getMaxRowKey(12);
	
	private String rowKey;
	
	/**
	 * id
	 */
	private Integer id;
	/**
	 *  登录账号
	 */
	private String mobile;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/** 
	 * 性别 
	 */
	private Boolean sex;
	/** 
	 * 年龄
	 */
	private Integer age;
	/**
	 * 省外键
	 */
	private Integer provinceId;
	/**
	 * 市外键
	 */
	private Integer cityId;
	/**
	 * 区外键
	 */
	private Integer areaId;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 经度
	 */
	private Float lng;
	/**
	 * 纬度
	 */
	private Float lat;
	/**
	 * 用户分类id
	 */
	private Integer userSortId;
	/**
	 * 头像ID
	 */
	private Integer imageId;
	/**
	 * 账号状态
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getLng() {
		return lng;
	}
	public void setLng(Float lng) {
		this.lng = lng;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Integer getUserSortId() {
		return userSortId;
	}
	public void setUserSortId(Integer userSortId) {
		this.userSortId = userSortId;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
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
		System.arraycopy(rowkey, 0, dest, 0, 4);//前4个字节id
		this.id=Bytes.toInt(dest);
	}
	public static String getMaxRowKey(int num){
		byte[] rowkey=new byte[num];
		for(int i=0;i<num;i++){
			rowkey[i]=(byte)0xff;
		}
		return new String(rowkey);
	}
}
