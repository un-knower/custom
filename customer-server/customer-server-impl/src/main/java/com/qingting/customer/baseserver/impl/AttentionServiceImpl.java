package com.qingting.customer.baseserver.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.AttentionService;
import com.qingting.customer.common.pojo.hbasedo.Attention;
import com.qingting.customer.dao.AttentionDAO;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
@Service("attentionService")
public class AttentionServiceImpl implements AttentionService {
	@Resource
	AttentionDAO attentionDAO;
	@Override
	public void insertAttentionByUserId(Attention attention, Integer userId) {
		attentionDAO.insertAttentionByUserId(attention, userId);
	}

	@Override
	public void deleteAttentionByUserIdAndCalendar(Integer userId, Calendar calendar) {
		attentionDAO.deleteAttentionByUserIdAndCalendar(userId, calendar);
	}

	@Override
	public void updateAttentionByUserIdAndCalendar(Attention attention, Integer userId, Calendar calendar) {
		attentionDAO.updateAttentionByUserIdAndCalendar(attention, userId, calendar);
	}

	@Override
	public List<SimpleHbaseDOWithKeyResult<Attention>> listAttentionByUserId(Integer userId) {
		return attentionDAO.listAttentionByUserId(userId);
	}

}
