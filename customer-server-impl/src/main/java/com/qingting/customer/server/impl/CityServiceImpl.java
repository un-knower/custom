package com.qingting.customer.server.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.model.hbasedo.City;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.CityDAO;
import com.qingting.customer.server.CityService;
@Service("cityService")
public class CityServiceImpl implements CityService {
	@Resource
	CityDAO cityDAO;
	@Override
	public void insert(City t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Collection<Integer> rkList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(City t) {
		// TODO Auto-generated method stub

	}

	@Override
	public City get(Integer rk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCityList(List<City> cityList) {
		cityDAO.insertCityList(cityList);
	}
	
	@Override
	public Pagination<City> listCity(String proCode,String code,Integer pageNo,Integer pageSize){
		return cityDAO.listCity(proCode,code,pageNo,pageSize);
	}

}
