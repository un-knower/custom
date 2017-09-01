package com.qingting.customer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alipay.simplehbase.client.rowkey.BytesRowKey;
import com.alipay.simplehbase.client.rowkey.StringRowKey;
import com.qingting.customer.model.hbasedo.ProjectSort;
import com.qingting.customer.model.util.DateUtil;
import com.qingting.customer.model.util.RowKeyUtil;
import com.qingting.customer.dao.ProjectSortDAO;
import com.qingting.customer.dao.util.SHCUtil;
import com.qingting.customer.hbase.doandkey.SimpleHbaseDOWithKeyResult;
import com.qingting.customer.hbase.rowkey.RowKey;
@Repository("projectSortDAO")
public class ProjectSortDAOImpl implements ProjectSortDAO {

	@Override
	public void insertProjectSort(ProjectSort projectSort) {
		RowKey rowKey = new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		SHCUtil.getSHC("projectSort").insertObject(rowKey, projectSort);
	}

	@Override
	public void deleteProjectSortByRowKey(String rowKey) {
		SHCUtil.getSHC("projectSort").delete(new StringRowKey(rowKey));
	}

	@Override
	public void updateProjectSortByRowKey(ProjectSort projectSort) {
		SHCUtil.getSHC("projectSort").updateObjectWithVersion(new StringRowKey(projectSort.getRowKey()), projectSort, projectSort.getVersion());
	}

	@Override
	public ProjectSort getProjectSortByRowKey(String rowKey) {
		SimpleHbaseDOWithKeyResult<ProjectSort> result = SHCUtil.getSHC("projectSort").findObjectAndKey(new StringRowKey(rowKey), ProjectSort.class);
		ProjectSort projectSort=result.getT();
		projectSort.setContentOfRowKey(result.getRowKey().toBytes());
		return projectSort;
	}

	@Override
	public List<ProjectSort> listProjectSort() {
		RowKey startRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getStartOfMillis()));
		RowKey endRowKey=new BytesRowKey(RowKeyUtil.getBytes(DateUtil.getMillisOfStart()));
		List<SimpleHbaseDOWithKeyResult<ProjectSort>> listDOWithKey = SHCUtil.getSHC("projectSort").findObjectAndKeyList(startRowKey,endRowKey, ProjectSort.class);
		List<ProjectSort> list=new ArrayList<ProjectSort>();
		for (SimpleHbaseDOWithKeyResult<ProjectSort> result : listDOWithKey) {
			ProjectSort projectSort = result.getT();
			projectSort.setContentOfRowKey(result.getRowKey().toBytes());
			list.add(projectSort);
		}
		return list;
	}

}
