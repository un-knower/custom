package com.qingting.customer.server.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.dao.WaterAreaDAO;
import com.qingting.customer.model.WaterArea;
import com.qingting.customer.server.WaterAreaService;
@Service("waterAreaService")
public class WaterAreaServiceImpl implements WaterAreaService{
	@Resource
	WaterAreaDAO waterAreaDAO;
	@Override
	public void insert(WaterArea waterArea) {
		waterAreaDAO.insert(waterArea);
	}

	@Override
	public void deleteById(Integer id) {
		waterAreaDAO.deleteById(id);
	}

	@Override
	public void updateById(WaterArea waterArea) {
		waterAreaDAO.updateById(waterArea);
	}

	@Override
	public WaterArea getById(Integer id) {
		return waterAreaDAO.getById(id);
	}

	@Override
	public Pagination<WaterArea> list(Pagination<WaterArea> page) {
		return waterAreaDAO.list(page);
	}


	@Override
	public List<WaterArea> listAll() {
		return waterAreaDAO.list();
	}

}
