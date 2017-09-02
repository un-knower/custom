package com.qingting.customer.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.RowKeyUtil;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.alipay.simplehbase.sequence.RedisSerialNum;
import com.smart.mvc.util.DateUtil;
import com.qingting.customer.dao.ProjectDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
import com.qingting.customer.model.Project;


@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {
	@Autowired
	public RedisTemplate<String, Integer> redisTemplate;
	@Override
	public void insertProject(Project project) {
		int num=RedisSerialNum.getSerialNum(redisTemplate, "project_id_seq");
		RowKey rowKey = RowKeyUtil.getRowKey(project.getUserId(), project.getComboId(),DateUtil.getMillisOfStart(),num);
		SHCUtil.getSHC("project").insertObject(rowKey, project);
	}

	@Override
	public void deleteProjectByRowKey(String rowKey) {
		SHCUtil.getSHC("project").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateProjectByRowKey(Project project) {
		SHCUtil.getSHC("project").updateObjectWithVersion(new StringRowKey(project.getRowKey()), project, project.getVersion());
		                           
	}
	
	@Override
	public List<Project> listProjectByUserId(Integer userId) {
		RowKey startRowKey=RowKeyUtil.getRowKey(userId, DateUtil.getStartOfMillis());
		RowKey endRowKey=RowKeyUtil.getRowKey(userId, DateUtil.getMillisOfStart());
		List<SimpleHbaseDOWithKeyResult<Project>> listDOWithKey = SHCUtil.getSHC("project").findObjectAndKeyList(startRowKey,endRowKey, Project.class);
		List<Project> list=new ArrayList<Project>();
		for (SimpleHbaseDOWithKeyResult<Project> result : listDOWithKey) {
			Project project = result.getT();
			//project.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(project);
		}
		return list;
	}

	@Override
	public Project getProjectByRowkey(String rowKey) {
		SimpleHbaseDOWithKeyResult<Project> result = SHCUtil.getSHC("project").findObjectAndKey(new StringRowKey(rowKey), Project.class);
		Project project=result.getT();
		//project.setContentOfRowKey(result.getRowKey().toBytes());
		return project;
	}
}
