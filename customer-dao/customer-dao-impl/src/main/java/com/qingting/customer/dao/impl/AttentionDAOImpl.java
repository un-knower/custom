package com.qingting.customer.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.util.SHCUtil;
import com.qingting.customer.common.pojo.hbasedo.Attention;
import com.qingting.customer.common.pojo.rowkey.AttentionRowKey;
import com.qingting.customer.common.pojo.util.DateUtil;
import com.qingting.customer.dao.AttentionDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;

@Repository("attentionDAO")
public class AttentionDAOImpl implements AttentionDAO{

	@Override
	public void insertAttentionByUserId(Attention attention, Integer userId) {
		SHCUtil.getSHC("attention").insertObject(new AttentionRowKey(userId), attention);
	}

	@Override
	public void deleteAttentionByUserIdAndCalendar(Integer userId, Calendar calendar) {
		SHCUtil.getSHC("attention").delete(new AttentionRowKey(userId,calendar));
	}

	@Override
	public void updateAttentionByUserIdAndCalendar(Attention attention, Integer userId, Calendar calendar) {
		SHCUtil.getSHC("attention").updateObjectWithVersion(new AttentionRowKey(userId,calendar), attention, attention.getVersion());
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<Attention>> listAttentionByUserId(Integer userId) {
		return SHCUtil.getSHC("attention").findObjectAndKeyList(new AttentionRowKey(userId,DateUtil.getStart()),new AttentionRowKey(userId,Calendar.getInstance()), Attention.class);
	}

}
