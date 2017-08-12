package com.qingting.customer.baseserver.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.EquipSortService;
import com.qingting.customer.common.pojo.hbasedo.EquipSort;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.EquipSortDAO;

@Service("equipSortService")
public class EquipSortServiceImpl implements EquipSortService {
	@Resource
	EquipSortDAO equipSortDAO;
	@Override
	public void insertEquipSort(EquipSort equipSort) {
		equipSortDAO.insertEquipSort(equipSort);
	}

	@Override
	public void deleteEquipSortByRowKey(String rowKey) {
		equipSortDAO.deleteEquipSortByRowKey(rowKey);
	}

	@Override
	public void updateEquipSortByRowKey(EquipSort equipSort) {
		equipSortDAO.updateEquipSortByRowKey(equipSort);
	}

	@Override
	public Pagination<EquipSort> listEquipSort(Integer pageNo, Integer pageSize) {
		return equipSortDAO.listEquipSort(pageNo, pageSize);
	}

	@Override
	public EquipSort getEquipSortById(Integer id) {
		return equipSortDAO.getEquipSortById(id);
	}


}
