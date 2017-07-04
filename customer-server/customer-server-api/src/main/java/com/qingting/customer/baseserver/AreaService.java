package com.qingting.customer.baseserver;

import java.util.List;

import com.qingting.customer.Service;
import com.qingting.customer.common.pojo.hbasedo.Area;

public interface AreaService extends Service<Area, Integer> {
	/**
	 * 
	 * @Title: insertAreaList
	 * @Description: 批量插入
	 * @param areaList 
	 * @return void
	 * @throws
	 */
	void insertAreaList(List<Area> areaList);
	/**
	 * 
	 * @Title: listArea
	 * @Description: 查询区信息
	 * @param id
	 * @param code
	 * @return 
	 * @return List<Area>
	 * @throws
	 */
	List<Area> listArea(Integer id,String code);
}
