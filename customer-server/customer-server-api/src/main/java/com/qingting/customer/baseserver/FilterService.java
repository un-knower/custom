package com.qingting.customer.baseserver;

import java.util.List;
import java.util.Map;

import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.common.pojo.model.Pagination;

public interface FilterService {
	void insert(Filter filter);
	void deleteById(Integer id);
	void updateById(Filter filter);
	Filter getById(Integer id);
	Pagination<Filter> list(Pagination<Filter> page);
	Map<Integer,Filter> listByIds(List<Integer> listIds);
}
