package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.Dao;
import com.qingting.customer.common.pojo.hbasedo.City;

public interface CityDAO extends Dao<City, Integer>{
	/**
	 * 
	 * @Title: insertCityList
	 * @Description: 批量插入
	 * @param cityList 
	 * @return void
	 * @throws
	 */
	void insertCityList(List<City> cityList);
	/**
	 * 
	 * @Title: listCity
	 * @Description: 查询市信息
	 * @param proCode
	 * @return 
	 * @return List<City>
	 * @throws
	 */
	List<City> listCity(String proCode);
}
