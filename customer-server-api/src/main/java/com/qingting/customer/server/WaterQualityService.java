package com.qingting.customer.server;

import com.qingting.customer.model.hbasedo.WaterQuality;
import com.qingting.customer.model.page.Pagination;

public interface WaterQualityService {
	void insert(WaterQuality waterQuality);
	void deleteById(Integer id);
	void updateById(WaterQuality waterQuality);
	WaterQuality getById(Integer id);
	WaterQuality getNewByWaterAreaId(Integer waterAreaId);
	Pagination<WaterQuality> list(Pagination<WaterQuality> page);
}
