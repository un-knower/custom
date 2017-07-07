package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.Dao;
import com.qingting.customer.common.pojo.hbasedo.Province;

public interface ProvinceDAO extends Dao<Province, Integer>{
	/**
	 * 
	 * @Title: insertProvinceList
	 * @Description: 批量插入
	 * @param proList 
	 * @return void
	 * @throws
	 */
	void insertProvinceList(List<Province> proList);
	/**
	 * 
	 * @Title: listProvince
	 * @Description: 查询省信息
	 * @param code
	 * @return 
	 * @return List<Province>
	 * @throws
	 */
	List<Province> listProvince(String code);
}
