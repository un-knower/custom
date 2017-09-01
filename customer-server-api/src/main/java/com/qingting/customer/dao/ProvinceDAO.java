package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.Dao;
import com.qingting.customer.model.hbasedo.Province;
import com.qingting.customer.model.page.Pagination;

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
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<Province>
	 * @throws
	 */
	Pagination<Province> listProvince(String code,Integer pageNo,Integer pageSize);
}
