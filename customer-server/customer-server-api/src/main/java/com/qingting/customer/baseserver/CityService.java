package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.Service;
import com.qingting.customer.common.pojo.hbasedo.City;
import com.qingting.customer.common.pojo.model.Pagination;

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
