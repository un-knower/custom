package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.Dao;
import com.qingting.customer.model.City;
import com.smart.mvc.model.Pagination;

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
	 * @param code
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<City>
	 * @throws
	 */
	Pagination<City> listCity(String proCode,String code,Integer pageNo,Integer pageSize);
}
