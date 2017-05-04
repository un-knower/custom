package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.AttentionService;
import com.qingting.customer.common.pojo.hbasedo.Attention;
import com.qingting.customer.dao.AttentionDAO;
@Service("attentionService")
public class AttentionServiceImpl implements AttentionService {
	@Resource
	AttentionDAO attentionDAO;

	@Override
	public void insertAttention(Attention attention) {
		attentionDAO.insertAttention(attention);
	}

	@Override
	public void deleteAttentionByRowKey(String rowKey) {
		attentionDAO.deleteAttentionByRowKey(rowKey);
	}

	@Override
	public void updateAttentionByRowKey(Attention attention) {
		attentionDAO.updateAttentionByRowKey(attention);
	}

	@Override
	public List<Attention> listAttentionByUserId(Integer userId) {
		return attentionDAO.listAttentionByUserId(userId);
	}
	
}
