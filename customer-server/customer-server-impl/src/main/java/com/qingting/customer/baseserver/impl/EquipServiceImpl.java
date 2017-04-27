package com.qingting.customer.baseserver.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

@Service("equipService")
public class EquipServiceImpl implements EquipService {
	@Resource
	EquipDAO equipDAO;
	@Override
	public void insertEquipByProjectId(Equip equip, Integer projectId) {
		equipDAO.insertEquipByProjectId(equip, projectId);
	}

	@Override
	public void deleteEquipByProjectIdAndCalendar(Integer projectId, Calendar calendar) {
		equipDAO.deleteEquipByProjectIdAndCalendar(projectId, calendar);
	}

	@Override
	public void updateEquipByProjectIdAndCalendar(Equip equip, Integer projectId, Calendar calendar) {
		equipDAO.updateEquipByProjectIdAndCalendar(equip, projectId, calendar);
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<Equip>> listEquipByProjectId(Integer projectId) {
		return equipDAO.listEquipByProjectId(projectId);
	}

}
