package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Province;

public interface ProvinceDAO {
	/**
	 * 
	 * @Title: insertProvince
	 * @Description: 插入省信息
	 * @param province 
	 * @return void
	 * @throws
	 */
	void insertProvince(Province province);
	/**
	 * 
	 * @Title: deleteProvinceByRowKey
	 * @Description: 删除省信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteProvinceByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateProvinceByRowKey
	 * @Description: 修改省信息通过rowKey
	 * @param province 
	 * @return void
	 * @throws
	 */
	void updateProvinceByRowKey(Province province);
	/**
	 * 
	 * @Title: getProvinceByCode
	 * @Description: 查询省信息通过编码
	 * @param code
	 * @return 
	 * @return Province
	 * @throws
	 */
	Province getProvinceByCode(String code);
	/**
	 * 
	 * @Title: listProvince
	 * @Description: 查询所有省信息
	 * @return 
	 * @return List<Province>
	 * @throws
	 */
	List<Province> listProvince();
}
