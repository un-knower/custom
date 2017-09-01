package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.common.pojo.hbasedo.WarnSort;
import com.qingting.customer.dao.WarnSortDAO;
import com.qingting.customer.server.WarnSortService;

@Service("warnSortService")
public class WarnSortServiceImpl implements WarnSortService {
	@Resource
	WarnSortDAO warnSortDAO;
	@Override
	public void insertWarnSort(WarnSort warnSort) {
		warnSortDAO.insertWarnSort(warnSort);
	}

	@Override
	public void deleteWarnSortByRowKey(String rowKey) {
		warnSortDAO.deleteWarnSortByRowKey(rowKey);
	}

	@Override
	public void updateWarnSortByRowKey(WarnSort warnSort) {
		warnSortDAO.updateWarnSortByRowKey(warnSort);
	}

	@Override
	public WarnSort getWarnSortByRowKey(String rowKey) {
		return warnSortDAO.getWarnSortByRowKey(rowKey);
	}

	@Override
	public List<WarnSort> listWarnSort() {
		return warnSortDAO.listWarnSort();
	}

}
