package com.qingting.customer.dao;

import java.util.List;

import com.qingting.customer.common.pojo.hbasedo.Area;

public interface AreaDAO {
	/**
	 * 
	 * @Title: insertArea
	 * @Description: 插入区信息
	 * @param area 
	 * @return void
	 * @throws
	 */
	void insertArea(Area area);
	/**
	 * 
	 * @Title: deleteAreaByRowKey
	 * @Description: 删除区信息通过rowKey
	 * @param rowKey 
	 * @return void
	 * @throws
	 */
	void deleteAreaByRowKey(String rowKey);
	/**
	 * 
	 * @Title: updateAreaByRowKey
	 * @Description: 修改区信息通过rowKey
	 * @param area 
	 * @return void
	 * @throws
	 */
	void updateAreaByRowKey(Area area);
	/**
	 * 
	 * @Title: getAreaByCode
	 * @Description: 获得区信息通过编码
	 * @param code
	 * @return 
	 * @return Area
	 * @throws
	 */
	Area getAreaByCode(String code);
	/**
	 * 
	 * @Title: listAreaByCityCode
	 * @Description: 获得市下边的所有区
	 * @param cityCode
	 * @return 
	 * @return List<Area>
	 * @throws
	 */
	List<Area> listAreaByCityCode(String cityCode);
}
