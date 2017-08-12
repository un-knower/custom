package com.qingting.customer.baseserver.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.FormulaService;
import com.qingting.customer.common.pojo.hbasedo.Formula;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.FormulaDAO;

@Service("formulaService")
public class FormulaServiceImpl implements FormulaService {
	@Resource
	FormulaDAO formulaDAO;

	@Override
	public void insert(Formula formula) {
		formulaDAO.insert(formula);
	}

	@Override
	public void deleteById(Integer id) {
		formulaDAO.deleteById(id);
	}

	@Override
	public void updateById(Formula formula) {
		formulaDAO.updateById(formula);
	}

	@Override
	public Formula getById(Integer id) {
		return formulaDAO.getById(id);
	}

	@Override
	public Pagination<Formula> list(Pagination<Formula> page) {
		return formulaDAO.list(page);
	}

	@Override
	public Formula getByFilterIdAndOrder(Integer filterId, Byte order) {
		return formulaDAO.getByFilterIdAndOrder(filterId, order);
	}
	
}
