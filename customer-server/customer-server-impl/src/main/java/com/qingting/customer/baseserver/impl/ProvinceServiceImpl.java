package com.qingting.customer.baseserver.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.ProvinceService;
import com.qingting.customer.common.pojo.hbasedo.Province;
import com.qingting.customer.dao.ProvinceDAO;
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
	
	@Resource
	ProvinceDAO provinceDAO;
	
	@Override
	public void insert(Province t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Collection<Integer> rkList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Province t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Province get(Integer rk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertProvinceList(List<Province> proList) {
		provinceDAO.insertProvinceList(proList);
	}

	@Override
	public List<Province> listProvince(String code) {
		return provinceDAO.listProvince(code);
	}

}
