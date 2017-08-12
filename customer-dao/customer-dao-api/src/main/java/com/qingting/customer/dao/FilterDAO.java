package com.qingting.customer.dao;


import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.common.pojo.model.Pagination;

public interface FilterDAO {
	void insert(Filter filter);
	void deleteById(Integer id);
	void updateById(Filter filter);
	Filter getById(Integer id);
	Pagination<Filter> list(Pagination<Filter> page);
}
