package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.dao.EquipDAO;

@Service("equipService")
public class EquipServiceImpl implements EquipService {
	@Resource
	EquipDAO equipDAO;

	@Override
	public void insertEquip(Equip equip) {
		equipDAO.insertEquip(equip);
	}

	@Override
	public void deleteEquipByRowKey(String rowKey) {
		equipDAO.deleteEquipByRowKey(rowKey);
	}

	@Override
	public void updateEquipByRowKey(Equip equip) {
		equipDAO.updateEquipByRowKey(equip);
	}

	@Override
	public List<Equip> listEquipByProjectId(Integer projectId) {
		return equipDAO.listEquipByProjectId(projectId);
	}

	@Override
	public List<Equip> listEquipByUserId(Integer userId) {
		return null;
	}
	

}
