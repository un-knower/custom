package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.model.FilterGroup;
import com.qingting.customer.model.dto.FilterGroupDTO;
import com.smart.mvc.model.Pagination;

public interface FilterGroupService {
	void insert(FilterGroup filterGroup);
	void deleteById(Integer id);
	void updateById(FilterGroup filterGroup);
	FilterGroup getById(Integer id);
	Pagination<FilterGroup> list(Pagination<FilterGroup> page);
	//List<FilterGroup> list();
	List<FilterGroupDTO> listDTO();
}
