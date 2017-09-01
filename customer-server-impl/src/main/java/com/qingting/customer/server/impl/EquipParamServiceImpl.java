package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.model.hbasedo.EquipParam;
import com.qingting.customer.dao.EquipParamDAO;
import com.qingting.customer.server.EquipParamService;

@Service("equipParamService")
public class EquipParamServiceImpl implements EquipParamService {
	@Resource
	EquipParamDAO equipParamDAO;
	@Override
	public void insertEquipParam(EquipParam equipParam) {
		equipParamDAO.insertEquipParam(equipParam);
	}

	@Override
	public void deleteEquipParamByRowKey(String rowKey) {
		equipParamDAO.deleteEquipParamByRowKey(rowKey);
	}

	@Override
	public void updateEquipParamByRowKey(EquipParam equipParam) {
		equipParamDAO.updateEquipParamByRowKey(equipParam);
	}

	@Override
	public EquipParam getEquipParamOfEnableByEquipId(Integer equipId) {
		return equipParamDAO.getEquipParamOfEnableByEquipId(equipId);
	}

	@Override
	public List<EquipParam> listEquipParamByEquipId(Integer equipId) {
		return equipParamDAO.listEquipParamByEquipId(equipId);
	}

}
