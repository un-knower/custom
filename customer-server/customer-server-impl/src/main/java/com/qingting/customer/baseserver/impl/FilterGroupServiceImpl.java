package com.qingting.customer.baseserver.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.FilterGroupService;
import com.qingting.customer.common.pojo.dto.FilterGroupDTO;
import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.common.pojo.hbasedo.FilterGroup;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.FilterDAO;
import com.qingting.customer.dao.FilterGroupDAO;
@Service("filterGroupService")
public class FilterGroupServiceImpl implements FilterGroupService,com.qingting.operation.server.FilterGroupService {
	@Resource
	FilterGroupDAO filterGroupDAO;
	@Resource
	FilterDAO filterDAO;
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

	/*@Override
	public List<com.qingting.customer.common.pojo.hbasedo.FilterGroup> list() {
		return filterGroupDAO.list();
	}*/

	@Override
	public List<FilterGroupDTO> listDTO() {
		List<com.qingting.customer.common.pojo.hbasedo.FilterGroup> list = filterGroupDAO.list();
		Set<Integer> ids=new HashSet<Integer>();
		for (FilterGroup filterGroup : list) {
			ids.add(filterGroup.getOneFilterId());
			ids.add(filterGroup.getTwoFilterId());
			ids.add(filterGroup.getThreeFilterId());
			ids.add(filterGroup.getFourFilterId());
			ids.add(filterGroup.getFiveFilterId());
		}
		Map<Integer, Filter> filterListMap = filterDAO.listByIds(ids);
		List<FilterGroupDTO> listDTO=new ArrayList<FilterGroupDTO>();
		for (FilterGroup filterGroup : list) {
			FilterGroupDTO filterGroupDTO=new FilterGroupDTO();
			filterGroupDTO.setId(filterGroup.getId());
			filterGroupDTO.setOneFilterName(filterListMap.get(filterGroup.getOneFilterId()).getName());
			filterGroupDTO.setTwoFilterName(filterListMap.get(filterGroup.getTwoFilterId()).getName());
			filterGroupDTO.setThreeFilterName(filterListMap.get(filterGroup.getThreeFilterId()).getName());
			filterGroupDTO.setFourFilterName(filterListMap.get(filterGroup.getFourFilterId()).getName());
			filterGroupDTO.setFiveFilterName(filterListMap.get(filterGroup.getFiveFilterId()).getName());
			listDTO.add(filterGroupDTO);
		}
		return listDTO;
	}
	/*@Override
	public List<com.qingting.operation.model.FilterGroup> list() {
		return filterGroupDAO.list();
	}*/
	
	@Override
	public List<com.qingting.operation.model.FilterGroup> list() {
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
		
		List<com.qingting.operation.model.FilterGroup> result=new ArrayList<com.qingting.operation.model.FilterGroup>();
		for (com.qingting.customer.common.pojo.hbasedo.FilterGroup filterGroup : list) {
			com.qingting.operation.model.FilterGroup f = new com.qingting.operation.model.FilterGroup();
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
