package com.qingting.customer.dao;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qingting.customer.model.hbasedo.Filter;
import com.qingting.customer.model.page.Pagination;

public interface FilterDAO {
	void insert(Filter filter);
	void deleteById(Integer id);
	void updateById(Filter filter);
	Filter getById(Integer id);
	Pagination<Filter> list(Pagination<Filter> page);
	Map<Integer,Filter> listByIds(List<Integer> listIds);
	Map<Integer,Filter> listByIds(Set<Integer> setIds);
}
