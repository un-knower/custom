package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Card;
import com.qingting.customer.common.pojo.model.Pagination;

public interface CardDAO {
	void insert(Card card);
	Pagination<Card> list(Pagination<Card> page);
	List<Card> search(String number);
}
