package com.qingting.customer.server.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.model.hbasedo.Area;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.AreaDAO;
import com.qingting.customer.dao.ProvinceDAO;
import com.qingting.customer.server.AreaService;
@Service("areaService")
public class AreaServiceImpl implements AreaService {
	@Resource
	AreaDAO areaDAO;
	@Override
	public void insert(Area t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Collection<Integer> rkList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Area t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Area get(Integer rk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAreaList(List<Area> areaList) {
		areaDAO.insertAreaList(areaList);
	}

	@Override
	public Pagination<Area> listArea(String cityCode,String code,Integer pageNo,Integer pageSize) {
		return areaDAO.listArea(cityCode,code,pageNo,pageSize);
	}

}
