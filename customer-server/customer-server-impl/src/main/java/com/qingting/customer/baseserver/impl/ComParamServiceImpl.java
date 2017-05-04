package com.qingting.customer.baseserver.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.ComParamService;
import com.qingting.customer.common.pojo.hbasedo.ComParam;
import com.qingting.customer.dao.ComParamDAO;

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
