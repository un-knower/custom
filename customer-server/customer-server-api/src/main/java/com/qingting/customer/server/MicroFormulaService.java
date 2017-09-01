package com.qingting.customer.server;

import com.qingting.customer.common.pojo.hbasedo.MicroFormula;
import com.qingting.customer.common.pojo.model.Pagination;

public interface MicroFormulaService {
	void insert(MicroFormula microFormula);
	void deleteById(Integer id);
	void updateById(MicroFormula microFormula);
	MicroFormula getById(Integer id);
	Pagination<MicroFormula> list(Pagination<MicroFormula> page);
}
