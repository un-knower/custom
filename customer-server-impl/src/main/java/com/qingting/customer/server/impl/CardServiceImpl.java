package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.model.hbasedo.Card;
import com.qingting.customer.model.page.Pagination;
import com.qingting.customer.dao.CardDAO;
import com.qingting.customer.server.CardService;
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
