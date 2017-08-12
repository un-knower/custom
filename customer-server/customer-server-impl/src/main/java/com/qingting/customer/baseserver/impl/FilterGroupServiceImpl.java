package com.qingting.customer.baseserver.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.FilterGroupService;
import com.qingting.customer.common.pojo.hbasedo.FilterGroup;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.FilterGroupDAO;
@Service("filterGroupService")
public class FilterGroupServiceImpl implements FilterGroupService {
	@Resource
	FilterGroupDAO filterGroupDAO;
	@Override
	public void insert(FilterGroup filterGroup) {
		filterGroupDAO.insert(filterGroup);
	}

	@Override
	public void deleteById(Integer id) {
		filterGroupDAO.deleteById(id);
	}

	@Override
	public void updateById(FilterGroup filterGroup) {
		filterGroupDAO.updateById(filterGroup);
	}

	@Override
	public FilterGroup getById(Integer id) {
		return filterGroupDAO.getById(id);
	}

	@Override
	public Pagination<FilterGroup> list(Pagination<FilterGroup> page) {
		return filterGroupDAO.list(page);
	}

}
