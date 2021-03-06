package com.qingting.customer.server.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.qingting.customer.dao.MicroFormulaDAO;
import com.qingting.customer.model.MicroFormula;
import com.qingting.customer.server.MicroFormulaService;
@Service("microFormulaService")
public class MicroFormulaServiceImpl implements MicroFormulaService {
	@Resource
	MicroFormulaDAO microFormulaDAO; 
	@Override
	public void insert(MicroFormula microFormula) {
		microFormulaDAO.insert(microFormula);
	}

	@Override
	public void deleteById(Integer id) {
		microFormulaDAO.deleteById(id);
	}

	@Override
	public void updateById(MicroFormula microFormula) {
		microFormulaDAO.updateById(microFormula);
	}

	@Override
	public MicroFormula getById(Integer id) {
		return microFormulaDAO.getById(id);
	}

	@Override
	public Pagination<MicroFormula> list(Pagination<MicroFormula> page) {
		return microFormulaDAO.list(page);
	}

}
