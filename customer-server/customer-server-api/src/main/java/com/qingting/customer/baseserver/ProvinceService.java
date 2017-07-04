package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.Service;
import com.qingting.customer.common.pojo.hbasedo.Province;

public interface ProvinceService extends Service<Province, Integer> {
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
	 * @Description: 查询所有省信息
	 * @return 
	 * @return List<Province>
	 * @throws
	 */
	List<Province> listProvince(Integer id,String code);
}
