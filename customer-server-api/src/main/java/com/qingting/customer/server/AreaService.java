package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.Service;
import com.qingting.customer.model.Area;
import com.smart.mvc.model.Pagination;

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
	 * @param cityCode
	 * @param code
	 * @param pageNo
	 * @param pageSize
	 * @return 
	 * @return Pagination<Area>
	 * @throws
	 */
	Pagination<Area> listArea(String cityCode,String code,Integer pageNo,Integer pageSize);
}
