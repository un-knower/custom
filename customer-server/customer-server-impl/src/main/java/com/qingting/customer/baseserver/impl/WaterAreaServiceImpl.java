package com.qingting.customer.baseserver.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.WaterAreaService;
import com.qingting.customer.common.pojo.hbasedo.WaterArea;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.WaterAreaDAO;
@Service("waterAreaService")
public class WaterAreaServiceImpl implements WaterAreaService {
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

}
