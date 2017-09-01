package com.qingting.customer.dao;


import com.qingting.customer.model.hbasedo.WaterQuality;
import com.qingting.customer.model.page.Pagination;

public interface WaterQualityDAO {
	void insert(WaterQuality waterQuality);
	void deleteById(Integer id);
	void updateById(WaterQuality waterQuality);
	WaterQuality getById(Integer id);
	WaterQuality getNewByWaterAreaId(Integer waterAreaId);
	Pagination<WaterQuality> list(Pagination<WaterQuality> page);
}
