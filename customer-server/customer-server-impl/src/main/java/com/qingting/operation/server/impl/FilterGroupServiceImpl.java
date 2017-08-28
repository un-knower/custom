package com.qingting.operation.server.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.dao.FilterDAO;
import com.qingting.customer.dao.FilterGroupDAO;
import com.qingting.operation.model.FilterGroup;
import com.qingting.operation.server.FilterGroupService;

public class FilterGroupServiceImpl implements FilterGroupService {
	
	@Resource
	FilterGroupDAO filterGroupDAO;
	@Resource
	FilterDAO filterDAO;
	
	@Override
	public List<FilterGroup> list() {
		List<com.qingting.customer.common.pojo.hbasedo.FilterGroup> list = filterGroupDAO.list();
		
		Set<Integer> ids=new HashSet<Integer>();
		for (com.qingting.customer.common.pojo.hbasedo.FilterGroup filterGroup : list) {
			ids.add(filterGroup.getOneFilterId());
			ids.add(filterGroup.getTwoFilterId());
			ids.add(filterGroup.getThreeFilterId());
			ids.add(filterGroup.getFourFilterId());
			ids.add(filterGroup.getFiveFilterId());
		}
		Map<Integer, Filter> filterListMap = filterDAO.listByIds(ids);
		
		List<FilterGroup> result=new ArrayList<FilterGroup>();
		for (com.qingting.customer.common.pojo.hbasedo.FilterGroup filterGroup : list) {
			FilterGroup f = new FilterGroup();
			f.setId(filterGroup.getId());
			f.setName(
					filterListMap.get(filterGroup.getOneFilterId()).getName()+
					filterListMap.get(filterGroup.getTwoFilterId()).getName()+
					filterListMap.get(filterGroup.getThreeFilterId()).getName()+
					filterListMap.get(filterGroup.getFourFilterId()).getName()+
					filterListMap.get(filterGroup.getFiveFilterId()).getName()
					);
			result.add(f);
		}
		return result;
	}

}
