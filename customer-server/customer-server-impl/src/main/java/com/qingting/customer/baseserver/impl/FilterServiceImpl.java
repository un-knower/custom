package com.qingting.customer.baseserver.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.FilterService;
import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.FilterDAO;
@Service("filterService")
public class FilterServiceImpl implements FilterService {
	@Resource
	FilterDAO filterDAO;
	@Override
	public void insert(Filter filter) {
		filterDAO.insert(filter);
	}

	@Override
	public void deleteById(Integer id) {
		filterDAO.deleteById(id);
	}

	@Override
	public void updateById(Filter filter) {
		filterDAO.updateById(filter);
	}

	@Override
	public Filter getById(Integer id) {
		return filterDAO.getById(id);
	}

	@Override
	public Pagination<Filter> list(Pagination<Filter> page) {
		return filterDAO.list(page);
	}

	@Override
	public Map<Integer, Filter> listByIds(List<Integer> listIds) {
		return filterDAO.listByIds(listIds);
	}
	
}
