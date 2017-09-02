package com.qingting.customer.dao;


import java.util.List;

import com.qingting.customer.model.WaterArea;
import com.smart.mvc.model.Pagination;

public interface WaterAreaDAO {
	void insert(WaterArea waterArea);
	void deleteById(Integer id);
	void updateById(WaterArea waterArea);
	WaterArea getById(Integer id);
	Pagination<WaterArea> list(Pagination<WaterArea> page);
	List<WaterArea> list();
}
