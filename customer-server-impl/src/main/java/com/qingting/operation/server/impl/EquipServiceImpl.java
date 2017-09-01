package com.qingting.operation.server.impl;

import javax.annotation.Resource;

import com.qingting.customer.dao.EquipDAO;
import com.qingting.operation.server.EquipService;
import com.qingting.platform.common.Result;

public class EquipServiceImpl implements EquipService {
	@Resource
	EquipDAO equipDAO;
	
	@Override
	public Result bindEquip(Integer userId, Integer filterGroupId, Integer waterAreaId, String equipCode) {
		String str = equipDAO.updateUserAndRelevanceOfNewEquip(userId, filterGroupId, waterAreaId, equipCode);
		if(str==null){
			return Result.createSuccessResult();
		}else{
			Result result = Result.createFailureResult();
			result.setMessage(str);
			return result;
		}
	}

}
