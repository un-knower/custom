package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.dao.AttentionDAO;
import com.qingting.customer.model.Attention;
import com.qingting.customer.server.AttentionService;
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
