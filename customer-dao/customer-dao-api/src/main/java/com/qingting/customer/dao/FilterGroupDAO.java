package com.qingting.customer.dao;


import com.qingting.customer.common.pojo.hbasedo.FilterGroup;
import com.qingting.customer.common.pojo.model.Pagination;

public interface FilterGroupDAO {
	void insert(FilterGroup filterGroup);
	void deleteById(Integer id);
	void updateById(FilterGroup filterGroup);
	FilterGroup getById(Integer id);
	Pagination<FilterGroup> list(Pagination<FilterGroup> page);
}
