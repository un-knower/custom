package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.EquipParamService;
import com.qingting.customer.common.pojo.hbasedo.EquipParam;
import com.qingting.customer.dao.EquipParamDAO;

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
