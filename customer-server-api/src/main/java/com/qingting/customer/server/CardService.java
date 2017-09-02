package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.model.Card;
import com.smart.mvc.model.Pagination;

public interface CardService {
	void insert(Card card);
	Pagination<Card> list(Pagination<Card> page);
	List<Card> search(String number);
}
