package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.smart.mvc.util.DateUtil;
import com.qingting.customer.dao.EquipParamDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.EquipParam;

@Repository("equipParamDAO")
public class EquipParamDAOImpl implements EquipParamDAO {
	@Override
	public void insertEquipParam(EquipParam equipParam) {
		RowKey rowKey = RowKeyUtil.getRowKey(equipParam.getEquipId(), DateUtil.getMillisOfStart());
		SHCUtil.getSHC("equipParam").insertObject(rowKey, equipParam);
	}

	@Override
	public void deleteEquipParamByRowKey(String rowKey) {
		SHCUtil.getSHC("equipParam").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateEquipParamByRowKey(EquipParam equipParam) {
		SHCUtil.getSHC("equipParam").updateObjectWithVersion(new StringRowKey(equipParam.getRowKey()), equipParam, equipParam.getVersion());
	}

	@Override
	public EquipParam getEquipParamOfEnableByEquipId(Integer equipId) {
		RowKey startRowKey=RowKeyUtil.getRowKey(equipId, DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(equipId, DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<EquipParam>> listDOWithKey = SHCUtil.getSHC("equipParam").findObjectAndKeyList(startRowKey,endRowKey, EquipParam.class);
		
		/*if(listDOWithKey.size()>1)
			throw new RuntimeException("存在多个激活的通用参数！请检查程序逻辑");
		else if(listDOWithKey.size()==1){
			List<EquipParam> list=new ArrayList<EquipParam>();
			for (SimpleHbaseDOWithKeyResult<EquipParam> result : listDOWithKey) {
				EquipParam equipParam = result.getT();
				equipParam.setContentOfRowKey(result.getRowKey().toBytes());
				list.add(equipParam);
			}
			return list.get(0);
		}else 
			return null;*/
		List<EquipParam> list=new ArrayList<EquipParam>();
		for (SimpleHbaseDOWithKeyResult<EquipParam> result : listDOWithKey) {
			EquipParam equipParam = result.getT();
			if(equipParam.getEnable()){
				//equipParam.setContentOfRowKey(result.getRowKey().toBytes());
				list.add(equipParam);
			}
		}
		if(listDOWithKey.size()>1)
			throw new RuntimeException("存在多个激活的通用参数！请检查程序逻辑");
		else 
			return list.get(0); 
	}

	@Override
	public List<EquipParam> listEquipParamByEquipId(Integer equipId) {
		RowKey startRowKey=RowKeyUtil.getRowKey(equipId, DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(equipId, DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<EquipParam>> listDOWithKey = SHCUtil.getSHC("equipParam").findObjectAndKeyList(startRowKey,endRowKey, EquipParam.class);
		List<EquipParam> list=new ArrayList<EquipParam>();
		for (SimpleHbaseDOWithKeyResult<EquipParam> result : listDOWithKey) {
			EquipParam equipParam = result.getT();
			//equipParam.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(equipParam);
		}
		return list;
	}
}
