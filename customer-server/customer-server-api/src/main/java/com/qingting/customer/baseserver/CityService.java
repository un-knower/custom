package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.Service;
import com.qingting.customer.common.pojo.hbasedo.City;

public interface CityService extends Service<City, Integer> {
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
	 * @param id
	 * @param code
	 * @return 
	 * @return List<City>
	 * @throws
	 */
	List<City> listCity(Integer id,String code);
}