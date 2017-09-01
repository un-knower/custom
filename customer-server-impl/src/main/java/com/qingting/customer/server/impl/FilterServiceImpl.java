package com.qingting.customer.server.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.model.hbasedo.Filter;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.FilterDAO;
import com.qingting.customer.server.FilterService;
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
