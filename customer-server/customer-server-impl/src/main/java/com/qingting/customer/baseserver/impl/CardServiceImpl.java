package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.CardService;
import com.qingting.customer.common.pojo.hbasedo.Card;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.CardDAO;
@Service("cardService")
public class CardServiceImpl implements CardService {
	@Resource
	CardDAO cardDAO;
	@Override
	public void insert(Card card) {
		cardDAO.insert(card);
	}

	@Override
	public Pagination<Card> list(Pagination<Card> page) {
		return cardDAO.list(page);
	}

	@Override
	public List<Card> search(String number) {
		return cardDAO.search(number);
	}

}
