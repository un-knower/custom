package com.qingting.customer.dao.impl;

import java.util.Calendar;
import java.util.List;

import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.EquipParam;
import com.qingting.customer.common.pojo.rowkey.EquipParamRowKey;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.dao.EquipParamDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

public class EquipParamDAOImpl implements EquipParamDAO {

	@Override
	public void insertEquipParamByEquipIdAndEnable(EquipParam equipParam, Integer equipId, Boolean enable) {
		SHCUtil.getSHC("equipParam").insertObject(new EquipParamRowKey(equipId,enable), equipParam);
	}

	@Override
	public void deleteEquipParamByEquipIdAndEnableAndCalendar(Integer equipId, Boolean enable, Calendar calendar) {
		SHCUtil.getSHC("equipParam").delete(new EquipParamRowKey(equipId,enable,calendar));
	}

	@Override
	public void updateEquipParamByEquipIdAndEnableAndCalendar(EquipParam equipParam, Integer equipId, Boolean enable,
			Calendar calendar) {
		SHCUtil.getSHC("equipParam").updateObjectWithVersion(new EquipParamRowKey(equipId,enable,calendar), equipParam, equipParam.getVersion());
	}

	@Override
	public EquipParam getEquipParamByEquipIdOfEnable(Integer equipId) {
		List<EquipParam> list=SHCUtil.getSHC("equipParam").findObjectList(new EquipParamRowKey(equipId,true,DateUtil.getStart()),new EquipParamRowKey(equipId,true,Calendar.getInstance()), EquipParam.class);
		if(list.size()>1)
			throw new RuntimeException("存在多个激活的通用参数！请检查程序逻辑");
		else if(list.size()==1)
			return list.get(0);
		else 
			return null;
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<EquipParam>> listEquipParamAndKeyByEquipId(Integer equipId) {
		List<SimpleHbaseDOWithKeyResult<EquipParam>> list=SHCUtil.getSHC("equipParam").findObjectAndKeyList(new EquipParamRowKey(equipId,false,DateUtil.getStart()),new EquipParamRowKey(equipId,true,Calendar.getInstance()), EquipParam.class);
		return list;
	}

}
