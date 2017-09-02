package com.qingting.customer.server.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.dao.EquipSortDAO;
import com.qingting.customer.model.EquipSort;
import com.qingting.customer.server.EquipSortService;

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

	@Override
	public List<EquipSort> listEquipSort() {
		return equipSortDAO.listEquipSort();
	}


}
