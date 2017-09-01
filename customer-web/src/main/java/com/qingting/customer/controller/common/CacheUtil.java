package com.qingting.customer.controller.common;

import javax.annotation.Resource;

import com.qingting.customer.common.pojo.common.FilterOrder;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.FilterGroup;
import com.qingting.customer.common.pojo.hbasedo.Formula;
import com.qingting.customer.common.pojo.hbasedo.MicroFormula;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.hbasedo.WaterArea;
import com.qingting.customer.common.pojo.hbasedo.WaterQuality;
import com.qingting.customer.server.EquipService;
import com.qingting.customer.server.FilterGroupService;
import com.qingting.customer.server.FilterService;
import com.qingting.customer.server.FormulaService;
import com.qingting.customer.server.MicroFormulaService;
import com.qingting.customer.server.MonitorService;
import com.qingting.customer.server.WaterAreaService;
import com.qingting.customer.server.WaterQualityService;
import com.smart.mvc.cache.RedisCache;

public class CacheUtil {
	@Resource
	private static RedisCache<Equip> equipRedisCache;
	@Resource
	private static RedisCache<WaterArea> waterAreaRedisCache;
	@Resource
	private static RedisCache<WaterQuality> waterQualityRedisCache;
	@Resource
	private static RedisCache<FilterGroup> filterGroupRedisCache;
	@Resource
	private static RedisCache<Formula> formulaRedisCache;
	@Resource
	private static RedisCache<MicroFormula> microFormulaRedisCache;
	@Resource
	private static RedisCache<Monitor> monitorRedisCache;
	
	@Resource 
	private static MonitorService monitorService;
	@Resource 
	private static EquipService equipService;
	@Resource
	private static WaterAreaService waterAreaService;
	@Resource
	private static WaterQualityService waterQualityService;
	
	@Resource
	private static FilterGroupService filterGroupService;
	@Resource
	private static FilterService filterService;
	@Resource
	private static FormulaService formulaService;
	
	@Resource
	private static MicroFormulaService microFormulaService;
	
	//查设备
	public static Equip getEquip(String equipCode){
		Equip equip = equipRedisCache.get("equip/"+equipCode);
		if(equip==null){
			equip = equipService.getEquip(equipCode);
			equipRedisCache.set("equip/"+equipCode, equip);
		}
		return equip;
	}
	public static WaterArea getWaterArea(Integer waterAreaId){
		//查水区域
		WaterArea waterArea = waterAreaRedisCache.get("waterArea/"+waterAreaId);
		if(waterArea==null){
			waterArea = waterAreaService.getById(waterAreaId);
			waterAreaRedisCache.set("waterArea/"+waterAreaId,waterArea);
		}
		return waterArea;
	}
	public static WaterQuality getWaterQuality(Integer waterAreaId){
		//查水质
		WaterQuality waterQuality = waterQualityRedisCache.get("waterQuality/"+waterAreaId);
		if(waterQuality==null){
			waterQuality = waterQualityService.getNewByWaterAreaId(waterAreaId);
			waterQualityRedisCache.set("waterQuality/"+waterAreaId,waterQuality);
		}
		return waterQuality;
	}
		
		/*equipParam.setChlorine(waterQuality.getChlorine());
		equipParam.setTurbidity(waterQuality.getTurbidity());*/
	public static FilterGroup getFilterGroup(Integer filterGroupId){	
		//查滤芯组合
		FilterGroup filterGroup = filterGroupRedisCache.get("filterGroup/"+filterGroupId);
		if(filterGroup==null){
			filterGroup = filterGroupService.getById(filterGroupId);
			filterGroupRedisCache.set("filterGroup/"+filterGroupId,filterGroup);
		}
		return filterGroup;
	}
	public static Formula getFormula(Integer filterId,Byte order){
		//查滤芯计算公式
		Formula formula = formulaRedisCache.get("formula/"+filterId+"/"+order);
		if(formula==null){
			formula = formulaService.getByFilterIdAndOrder(filterId, order);
			formulaRedisCache.set("formula/"+filterId+"/"+order,formula);
		}
		return formula;
	}
		/*equipParam.setOneFormula(oneFormula.getFormula());*/
	
		/*Formula twoFormula = formulaRedisCache.get("formula/"+filterGroup.getTwoFilterId()+"/"+FilterOrder.TWO.getOrder());
		if(twoFormula==null){
			twoFormula = formulaService.getByFilterIdAndOrder(filterGroup.getTwoFilterId(), FilterOrder.TWO.getOrder());
			formulaRedisCache.set("formula/"+filterGroup.getTwoFilterId()+"/"+FilterOrder.TWO.getOrder(),twoFormula);
		}
		equipParam.setTwoFormula(twoFormula.getFormula());
		
		Formula threeFormula = formulaRedisCache.get("formula/"+filterGroup.getThreeFilterId()+"/"+FilterOrder.THREE.getOrder());
		if(threeFormula==null){
			threeFormula = formulaService.getByFilterIdAndOrder(filterGroup.getThreeFilterId(), FilterOrder.THREE.getOrder());
			formulaRedisCache.set("formula/"+filterGroup.getThreeFilterId()+"/"+FilterOrder.THREE.getOrder(),threeFormula);
		}
		equipParam.setThreeFormula(threeFormula.getFormula());
		
		Formula fourFormula = formulaRedisCache.get("formula/"+filterGroup.getFourFilterId()+"/"+FilterOrder.FOUR.getOrder());
		if(fourFormula==null){
			fourFormula = formulaService.getByFilterIdAndOrder(filterGroup.getFourFilterId(), FilterOrder.FOUR.getOrder());
			formulaRedisCache.set("formula/"+filterGroup.getFourFilterId()+"/"+FilterOrder.FOUR.getOrder(),fourFormula);
		}
		equipParam.setFourFormula(fourFormula.getFormula());
		
		Formula fiveFormula = formulaRedisCache.get("formula/"+filterGroup.getFiveFilterId()+"/"+FilterOrder.FIVE.getOrder());
		if(fiveFormula==null){
			fiveFormula = formulaService.getByFilterIdAndOrder(filterGroup.getFiveFilterId(), FilterOrder.FIVE.getOrder());
			formulaRedisCache.set("formula/"+filterGroup.getFiveFilterId()+"/"+FilterOrder.FIVE.getOrder(),fiveFormula);
		}
		equipParam.setFiveFormula(fiveFormula.getFormula());*/
	public static MicroFormula getMicroFormula(Integer microId){	
		//查微生物公式
		MicroFormula microFormula = microFormulaRedisCache.get("microFormula/"+microId);
		if(microFormula==null){
			microFormula = microFormulaService.getById(microId);
			microFormulaRedisCache.set("microFormula/"+microId,microFormula);
		}
		return microFormula;
	}
		/*equipParam.setMicroFormula(microFormula.getFormula());*/
	
	public static Monitor getMonitor(String equipCode){
		Monitor monitor = monitorRedisCache.get("monitor/"+equipCode);
		if(monitor==null){
			monitor=monitorService.getMonitorOfNewByEquipCode(equipCode);
			monitorRedisCache.set("monitor/"+equipCode,monitor);
		}
		return monitor;
	}
}
