package com.qingting.customer.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.ComParam;
import com.qingting.customer.common.pojo.rowkey.ComParamRowKey;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.dao.ComParamDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
@Repository("comParamDAO")
public class ComParamDAOImpl implements ComParamDAO {

	@Override
	public void insertComParamByEnable(ComParam comParam, Boolean enable) {
		SHCUtil.getSHC("comParam").insertObject(new ComParamRowKey(enable), comParam);
	}

	@Override
	public void deleteComParamByEnableAndCalendar(Boolean enable, Calendar calendar) {
		SHCUtil.getSHC("comParam").delete(new ComParamRowKey(enable,calendar));
	}

	@Override
	public void updateComParamByEnableAndCalendar(ComParam comParam,Boolean enable, Calendar calendar) {
		SHCUtil.getSHC("comParam").updateObjectWithVersion(new ComParamRowKey(enable,calendar), comParam, comParam.getVersion());
	}

	@Override
	public ComParam getComParamOfEnable() {
		List<ComParam> list=SHCUtil.getSHC("comParam").findObjectList(new ComParamRowKey(true,DateUtil.getStart()),new ComParamRowKey(true,Calendar.getInstance()), ComParam.class);
		if(list.size()>1)
			throw new RuntimeException("存在多个激活的通用参数！请检查程序逻辑");
		else if(list.size()==1)
			return list.get(0);
		else 
			return null;
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<ComParam>> listComParamAndKey() {
		List<SimpleHbaseDOWithKeyResult<ComParam>> list = SHCUtil.getSHC("comParam").findObjectAndKeyList(new ComParamRowKey(true,DateUtil.getStart()),new ComParamRowKey(true,Calendar.getInstance()), ComParam.class);
		return list;
	}

}
