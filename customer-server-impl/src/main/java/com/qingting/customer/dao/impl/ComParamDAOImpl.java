package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.smart.mvc.util.DateUtil;
import com.qingting.customer.dao.ComParamDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.ComParam;
@Repository("comParamDAO")
public class ComParamDAOImpl implements ComParamDAO {
	@Override
	public void insertComParam(ComParam comParam) {
		RowKey rowKey = RowKeyUtil.getRowKey(DateUtil.getMillisOfStart());
		SHCUtil.getSHC("comParam").insertObject(rowKey, comParam);
	}

	@Override
	public void deleteComParamByRowKey(String rowKey) {
		SHCUtil.getSHC("comParam").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateComParamByRowKey(ComParam comParam) {
		SHCUtil.getSHC("comParam").updateObjectWithVersion(new StringRowKey(comParam.getRowKey()), comParam, comParam.getVersion());
	}

	@Override
	public ComParam getComParamOfEnable() {
		RowKey startRowKey=RowKeyUtil.getRowKey(true, DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(true, DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<ComParam>> listDOWithKey = SHCUtil.getSHC("comParam").findObjectAndKeyList(startRowKey,endRowKey, ComParam.class);
		
		/*if(listDOWithKey.size()>1)
			throw new RuntimeException("存在多个激活的通用参数！请检查程序逻辑");
		else if(listDOWithKey.size()==1){
			List<ComParam> list=new ArrayList<ComParam>();
			for (SimpleHbaseDOWithKeyResult<ComParam> result : listDOWithKey) {
				ComParam comParam = result.getT();
				comParam.setContentOfRowKey(result.getRowKey().toBytes());
				list.add(comParam);
			}
			return list.get(0);
		}else 
			return null;*/
		
		List<ComParam> list=new ArrayList<ComParam>();
		for (SimpleHbaseDOWithKeyResult<ComParam> result : listDOWithKey) {
			ComParam comParam = result.getT();
			if(comParam.getEnable()){
				//comParam.setContentOfRowKey(result.getRowKey().toBytes());
				list.add(comParam);
			}
		}
		if(listDOWithKey.size()>1)
			throw new RuntimeException("存在多个激活的通用参数！请检查程序逻辑");
		else
			return list.get(0);
		
	}

	@Override
	public List<ComParam> listComParam() {
		RowKey startRowKey=RowKeyUtil.getRowKey(false, DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(true, DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<ComParam>> listDOWithKey = SHCUtil.getSHC("comParam").findObjectAndKeyList(startRowKey,endRowKey, ComParam.class);
		List<ComParam> list=new ArrayList<ComParam>();
		for (SimpleHbaseDOWithKeyResult<ComParam> result : listDOWithKey) {
			ComParam comParam = result.getT();
			//comParam.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(comParam);
		}
		return list;
	}
}
