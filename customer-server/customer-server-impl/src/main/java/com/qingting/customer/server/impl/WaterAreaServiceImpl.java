package com.qingting.customer.server.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.common.pojo.hbasedo.WaterArea;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.WaterAreaDAO;
import com.qingting.customer.server.WaterAreaService;
@Service("waterAreaService")
public class WaterAreaServiceImpl implements WaterAreaService,com.qingting.operation.server.WaterAreaService {
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
	public List<com.qingting.operation.model.WaterArea> list() {
		 List<WaterArea> list = waterAreaDAO.list();
		 List<com.qingting.operation.model.WaterArea> result = new ArrayList<com.qingting.operation.model.WaterArea>();
		 for (WaterArea waterArea : list) {
			 com.qingting.operation.model.WaterArea w = new com.qingting.operation.model.WaterArea();
			 w.setId(waterArea.getId());
			 w.setName(waterArea.getName());
			 result.add(w);
		}
		 return result;
	}

	@Override
	public List<WaterArea> listAll() {
		return waterAreaDAO.list();
	}

}
