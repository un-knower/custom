package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.model.hbasedo.Card;
import com.qingting.customer.model.page.Pagination;

public interface CardService {
	void insert(Card card);
	Pagination<Card> list(Pagination<Card> page);
	List<Card> search(String number);
}
