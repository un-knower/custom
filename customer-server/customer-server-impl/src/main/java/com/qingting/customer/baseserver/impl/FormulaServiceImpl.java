package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.FormulaService;
import com.qingting.customer.common.pojo.hbasedo.Formula;
import com.qingting.customer.dao.FormulaDAO;

@Service("formulaService")
public class FormulaServiceImpl implements FormulaService {
	@Resource
	FormulaDAO formulaDAO;
	@Override
	public void insertFormula(Formula formula) {
		formulaDAO.insertFormula(formula);
	}

	@Override
	public void deleteFormulaByRowKey(String rowKey) {
		formulaDAO.deleteFormulaByRowKey(rowKey);
	}

	@Override
	public void updateFormulaByRowKey(Formula formula) {
		formulaDAO.updateFormulaByRowKey(formula);
	}

	@Override
	public Formula getFormulaByRowKey(String rowKey) {
		return formulaDAO.getFormulaByRowKey(rowKey);
	}

	@Override
	public List<Formula> listFormula() {
		return formulaDAO.listFormula();
	}

}
