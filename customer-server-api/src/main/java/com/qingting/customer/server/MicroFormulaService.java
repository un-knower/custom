package com.qingting.customer.server;

import com.qingting.customer.model.MicroFormula;
import com.smart.mvc.model.Pagination;

public interface MicroFormulaService {
	void insert(MicroFormula microFormula);
	void deleteById(Integer id);
	void updateById(MicroFormula microFormula);
	MicroFormula getById(Integer id);
	Pagination<MicroFormula> list(Pagination<MicroFormula> page);
}
