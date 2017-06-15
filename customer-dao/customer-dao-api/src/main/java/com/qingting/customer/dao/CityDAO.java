package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.City;

public interface CityDAO {
	/**
	 * 
	 * @Title: insertCity
	 * @Description: 插入市信息
	 * @param city 
	 * @return void
	 * @throws
	 */
	void insertCity(City city);
	/**
	 * 
	 * @Title: deleteCityByRowKey
	 * @Description: 删除市信息
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteCityByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateCityByRowKey
	 * @Description: 修改市信息通过rowKey
	 * @param city 
	 * @return void
	 * @throws
	 */
	void updateCityByRowKey(City city);
	/**
	 * 
	 * @Title: getCityByCode
	 * @Description: 查询市信息通过编码
	 * @param code
	 * @return 
	 * @return City
	 * @throws
	 */
	City getCityByCode(String code);
	/**
	 * 
	 * @Title: listCityByProvinceCode
	 * @Description: 查询对应省的所有市
	 * @param provinceCode
	 * @return 
	 * @return List<City>
	 * @throws
	 */
	List<City> listCityByProvinceCode(String provinceCode);
}
