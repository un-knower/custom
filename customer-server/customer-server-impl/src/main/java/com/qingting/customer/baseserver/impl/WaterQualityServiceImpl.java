package com.qingting.customer.baseserver.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.WaterQualityService;
import com.qingting.customer.common.pojo.hbasedo.WaterQuality;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.WaterQualityDAO;
@Service("waterQualityService")
public class WaterQualityServiceImpl implements WaterQualityService {
	@Resource
	WaterQualityDAO waterQualityDAO;
	@Override
	public void insert(WaterQuality waterQuality) {
		waterQualityDAO.insert(waterQuality);
	}

	@Override
	public void deleteById(Integer id) {
		waterQualityDAO.deleteById(id);
	}

	@Override
	public void updateById(WaterQuality waterQuality) {
		waterQualityDAO.updateById(waterQuality);
	}

	@Override
	public WaterQuality getById(Integer id) {
		return waterQualityDAO.getById(id);
	}

	@Override
	public WaterQuality getNewByWaterAreaId(Integer waterAreaId) {
		return waterQualityDAO.getNewByWaterAreaId(waterAreaId);
	}

	@Override
	public Pagination<WaterQuality> list(Pagination<WaterQuality> page) {
		return waterQualityDAO.list(page);
	}

}