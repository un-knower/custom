package com.qingting.customer.server.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.common.pojo.hbasedo.Province;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.ProvinceDAO;
import com.qingting.customer.server.ProvinceService;
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
	public Pagination<Province> listProvince(String code,Integer pageNo,Integer pageSize) {
		return provinceDAO.listProvince(code,pageNo,pageSize);
	}

}
