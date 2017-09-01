package com.qingting.customer.server;

import com.qingting.customer.common.pojo.hbasedo.WaterQuality;
import com.qingting.customer.common.pojo.model.Pagination;

public interface WaterQualityService {
	void insert(WaterQuality waterQuality);
	void deleteById(Integer id);
	void updateById(WaterQuality waterQuality);
	WaterQuality getById(Integer id);
	WaterQuality getNewByWaterAreaId(Integer waterAreaId);
	Pagination<WaterQuality> list(Pagination<WaterQuality> page);
}
