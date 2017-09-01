package com.qingting.operation.server.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.qingting.customer.dao.WaterAreaDAO;
import com.qingting.operation.model.WaterArea;
import com.qingting.operation.server.WaterAreaService;

public class WaterAreaServiceImpl implements WaterAreaService {
	@Resource
	WaterAreaDAO waterAreaDAO;
	@Override
	public List<WaterArea> list() {
		List<com.qingting.customer.model.hbasedo.WaterArea> list = waterAreaDAO.list();
		List<WaterArea> result=new ArrayList<WaterArea>();
		for (com.qingting.customer.model.hbasedo.WaterArea waterArea : list) {
			WaterArea wa=new WaterArea();
			wa.setId(waterArea.getId());
			wa.setName(waterArea.getName());
			result.add(wa);
		}
		return result;
	}

}
