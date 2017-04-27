package com.qingting.customer.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.rowkey.EquipRowKey;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

@Repository("equipDAO")
public class EquipDAOImpl implements EquipDAO {

	@Override
	public void insertEquipByProjectId(Equip equip, Integer projectId) {
		SHCUtil.getSHC("equip").insertObject(new EquipRowKey(projectId), equip);
	}

	@Override
	public void deleteEquipByProjectIdAndCalendar(Integer projectId, Calendar calendar) {
		SHCUtil.getSHC("equip").delete(new EquipRowKey(projectId,calendar));
	}

	@Override
	public void updateEquipByProjectIdAndCalendar(Equip equip,Integer projectId, Calendar calendar) {
		SHCUtil.getSHC("equip").updateObjectWithVersion(new EquipRowKey(projectId,calendar), equip, equip.getVersion());
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<Equip>> listEquipByProjectId(Integer projectId) {
		return SHCUtil.getSHC("equip").findObjectAndKeyList(new EquipRowKey(projectId,DateUtil.getStart()),new EquipRowKey(projectId,Calendar.getInstance()), Equip.class);
	}

}
