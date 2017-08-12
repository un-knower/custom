package com.qingting.customer.baseserver;

import com.qingting.customer.common.pojo.hbasedo.WaterArea;
import com.qingting.customer.common.pojo.model.Pagination;

public interface WaterAreaService {
	void insert(WaterArea waterArea);
	void deleteById(Integer id);
	void updateById(WaterArea waterArea);
	WaterArea getById(Integer id);
	Pagination<WaterArea> list(Pagination<WaterArea> page);
}
