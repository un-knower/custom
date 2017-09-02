package com.qingting.customer.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.dao.ComParamDAO;
import com.qingting.customer.model.ComParam;
import com.qingting.customer.server.ComParamService;

@Service("comParamService")
public class ComParamServiceImpl implements ComParamService {
	@Resource
	ComParamDAO comParamDAO;
	@Override
	public void insertComParam(ComParam comParam) {
		comParamDAO.insertComParam(comParam);
	}

	@Override
	public void deleteComParamByRowKey(String rowKey) {
		comParamDAO.deleteComParamByRowKey(rowKey);
	}

	@Override
	public void updateComParamByRowKey(ComParam comParam) {
		comParamDAO.updateComParamByRowKey(comParam);
	}

	@Override
	public ComParam getComParamOfEnable() {
		return comParamDAO.getComParamOfEnable();
	}

	@Override
	public List<ComParam> listComParam() {
		return comParamDAO.listComParam();
	}

}
