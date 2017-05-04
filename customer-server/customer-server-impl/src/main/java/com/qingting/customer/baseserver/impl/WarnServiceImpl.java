package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.WarnService;
import com.qingting.customer.common.pojo.hbasedo.Warn;
import com.qingting.customer.dao.WarnDAO;

@Service("warnService")
public class WarnServiceImpl implements WarnService {
	@Resource
	WarnDAO warnDAO;
	@Override
	public void insertWarn(Warn warn) {
		warnDAO.insertWarn(warn);
	}

	@Override
	public void deleteWarnByRowKey(String rowKey) {
		warnDAO.deleteWarnByRowKey(rowKey);
	}

	@Override
	public void updateWarnByRowKey(Warn warn) {
		warnDAO.updateWarnByRowKey(warn);
	}

	@Override
	public Warn getWarnById(String rowKey) {
		return warnDAO.getWarnById(rowKey);
	}

	@Override
	public List<Warn> listWarn(String equipId) {
		return warnDAO.listWarn(equipId);
	}

}
