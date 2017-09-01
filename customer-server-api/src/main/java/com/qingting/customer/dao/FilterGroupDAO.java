package com.qingting.customer.dao;


import java.util.List;

import com.qingting.customer.model.hbasedo.FilterGroup;
import com.qingting.customer.model.page.Pagination;

public interface FilterGroupDAO {
	void insert(FilterGroup filterGroup);
	void deleteById(Integer id);
	void updateById(FilterGroup filterGroup);
	FilterGroup getById(Integer id);
	Pagination<FilterGroup> list(Pagination<FilterGroup> page);
	List<FilterGroup> list();
}
