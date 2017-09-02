package com.qingting.customer.server.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.model.Equip;
import com.qingting.customer.model.Filter;
import com.qingting.customer.model.FilterGroup;
import com.qingting.customer.model.Formula;
import com.qingting.customer.model.MicroFormula;
import com.qingting.customer.model.Monitor;
import com.qingting.customer.model.User;
import com.qingting.customer.model.WaterArea;
import com.qingting.customer.model.WaterQuality;
import com.qingting.customer.model.dto.EmpMonitorDTO;
import com.smart.mvc.model.Pagination;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.dao.FilterDAO;
import com.qingting.customer.dao.FilterGroupDAO;
import com.qingting.customer.dao.MicroFormulaDAO;
import com.qingting.customer.dao.MonitorDAO;
import com.qingting.customer.dao.UserDAO;
import com.qingting.customer.server.MonitorService;
import com.qingting.customer.server.common.CacheUtil;
import com.smart.mvc.cache.RedisCache;

@Service(value="monitorService")
public class MonitorServiceImpl implements MonitorService{
	
	@Resource
	MonitorDAO monitorDAO;
	@Resource
	EquipDAO equipDAO;
	
	@Resource
	UserDAO userDAO;
	
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
	
	@Override
	public EmpMonitorDTO getMonitorOfNewOfEmp(String equipCode){
		Monitor monitor = monitorDAO.getMonitorOfNewByEquipCode(equipCode);
		
		EmpMonitorDTO empMonitorDTO=new EmpMonitorDTO();
		empMonitorDTO.setCollectTime(monitor.getCollectTime());
		empMonitorDTO.setCreateTime(monitor.getCreateTime());
		empMonitorDTO.setEquipCode(monitor.getEquipCode());
		empMonitorDTO.setFlow(monitor.getFlow());
		empMonitorDTO.setHumidity(monitor.getHumidity());
		empMonitorDTO.setLeak(monitor.getLeak());
		empMonitorDTO.setPurTds(monitor.getPurTds());
		empMonitorDTO.setRawTds(monitor.getRawTds());
		empMonitorDTO.setTemp(monitor.getTemp());
		
		Integer userId = equipDAO.getUserIdOfUserEquip(monitor.getEquipCode());
		System.out.println("userId:"+userId);
		User user = userDAO.getUserById(userId);
		empMonitorDTO.setUserMobile(user.getMobile());
		empMonitorDTO.setUserName(user.getName());
		return empMonitorDTO;
	}
}
