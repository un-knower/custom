package com.qingting.customer.baseserver.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.baseserver.common.CacheUtil;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.common.pojo.hbasedo.FilterGroup;
import com.qingting.customer.common.pojo.hbasedo.Formula;
import com.qingting.customer.common.pojo.hbasedo.MicroFormula;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.hbasedo.WaterArea;
import com.qingting.customer.common.pojo.hbasedo.WaterQuality;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.dao.FilterDAO;
import com.qingting.customer.dao.FilterGroupDAO;
import com.qingting.customer.dao.MicroFormulaDAO;
import com.qingting.customer.dao.MonitorDAO;
import com.smart.mvc.cache.RedisCache;

@Service(value="monitorService")
public class MonitorServiceImpl implements MonitorService{
	
	@Resource
	MonitorDAO monitorDAO;
	@Resource
	EquipDAO equipDAO;
	/*@Resource
	FilterGroupDAO filterGroupDAO;
	@Resource
	FilterDAO filterDAO;
	@Resource
	MicroFormulaDAO microFormulaDAO;*/
	
	
	/*@Resource
	private RedisCache<Equip> equipRedisCache;
	@Resource
	private RedisCache<WaterArea> waterAreaRedisCache;
	@Resource
	private RedisCache<WaterQuality> waterQualityRedisCache;
	@Resource
	private RedisCache<FilterGroup> filterGroupRedisCache;
	@Resource
	private RedisCache<Formula> formulaRedisCache;
	@Resource
	private RedisCache<MicroFormula> microFormulaRedisCache;*/
	public void setMonitorDAO(MonitorDAO monitorDAO) {
		this.monitorDAO = monitorDAO;
	}

	public void setEquipDAO(EquipDAO equipDAO) {
		this.equipDAO = equipDAO;
	}
	
	
	@Override
	public void insertMonitor(Monitor monitor) {
		/*Equip equip = equipDAO.getEquip(monitor.getEquipCode());
		FilterGroup filterGroup = filterGroupDAO.getById(equip.getFilterGroupId());
		//第一级滤芯寿命到期
		if(monitor.getOneResult()>filterDAO.getById(filterGroup.getOneFilterId()).getLifeTime()){
			
		}
		//第二级滤芯寿命到期
		if(monitor.getTwoResult()>filterDAO.getById(filterGroup.getTwoFilterId()).getLifeTime()){
			
		}
		//第三级滤芯寿命到期
		if(monitor.getThreeResult()>filterDAO.getById(filterGroup.getThreeFilterId()).getLifeTime()){
			
		}		
		//第四级滤芯寿命到期
		if(monitor.getFourResult()>filterDAO.getById(filterGroup.getFourFilterId()).getLifeTime()){
			
		}
		//第五级滤芯寿命到期
		if(monitor.getFiveResult()>filterDAO.getById(filterGroup.getFiveFilterId()).getLifeTime()){
			
		}
		//微生物超标
		if(monitor.getMicroResult()>microFormulaDAO.getById(filterGroup.getMicroId()).getLimit()){
			
		}*/
		System.out.println("monitor:"+monitor);
		Equip equip = CacheUtil.getEquip(monitor.getEquipCode());
		System.out.println("equip:"+equip);
		FilterGroup filterGroup = CacheUtil.getFilterGroup(equip.getFilterGroupId());
		System.out.println("filterGroup:"+filterGroup);
		
		//第一级滤芯寿命到期
		Filter oneFilter = CacheUtil.getFilter(filterGroup.getOneFilterId());
		System.out.println("filter:"+oneFilter);
		if(monitor.getOneResult()>oneFilter.getLifeTime()){
			
		}
		//第二级滤芯寿命到期
		Filter twoFilter = CacheUtil.getFilter(filterGroup.getTwoFilterId());
		if(monitor.getTwoResult()>twoFilter.getId()){
			
		}
		//第三级滤芯寿命到期
		Filter threeFilter = CacheUtil.getFilter(filterGroup.getThreeFilterId());
		if(monitor.getThreeResult()>threeFilter.getLifeTime()){
			
		}		
		//第四级滤芯寿命到期
		Filter fourFilter = CacheUtil.getFilter(filterGroup.getFourFilterId());
		if(monitor.getFourResult()>fourFilter.getLifeTime()){
			
		}
		//第五级滤芯寿命到期
		Filter fiveFilter = CacheUtil.getFilter(filterGroup.getFiveFilterId());
		if(monitor.getFiveResult()>fiveFilter.getLifeTime()){
			
		}
		//微生物超标
		MicroFormula microFormula = CacheUtil.getMicroFormula(filterGroup.getMicroId());
		if(monitor.getMicroResult()>microFormula.getLimit()){
			
		}
		
		
		monitorDAO.insertMonitor(monitor);
	}

	

	@Override
	public void deleteMonitorByRowKey(String rowKey) {
		monitorDAO.deleteMonitorByRowKey(rowKey);
	}

	@Override
	public void updateMonitorByRowKey(Monitor monitor) {
		monitorDAO.updateMonitorByRowKey(monitor);
	}

	@Override
	public Monitor getMonitorByRowKey(String rowKey) {
		return monitorDAO.getMonitorByRowKey(rowKey);
	}
	
	@Override
	public Pagination<Monitor> listMonitor(Pagination<Monitor> page){
		return monitorDAO.listMonitor(page);
	}

	@Override
	public List<Monitor> listMonitorByEndTime(String equipCode, String type, int pageSize, Calendar endTime) {
		return monitorDAO.listMonitorByEndTime(equipCode, type, pageSize, endTime);
	}

	@Override
	public Monitor listTopMonitorOfNew(Integer userId) {
		Equip equip=equipDAO.getTopEquip(userId);
		return monitorDAO.getMonitorOfNewByEquipCode(equip.getEquipCode());
	}

	@Override
	public Monitor getMonitorOfNewByEquipCode(String equipCode) {
		return monitorDAO.getMonitorOfNewByEquipCode(equipCode);
	}

	@Override
	public boolean isExist(String equipCode, Calendar collectTime) {
		return monitorDAO.isExist(equipCode, collectTime);
	}
}
