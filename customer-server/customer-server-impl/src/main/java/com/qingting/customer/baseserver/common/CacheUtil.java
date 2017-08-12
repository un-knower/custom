package com.qingting.customer.baseserver.common;



import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.baseserver.FilterGroupService;
import com.qingting.customer.baseserver.FilterService;
import com.qingting.customer.baseserver.FormulaService;
import com.qingting.customer.baseserver.MicroFormulaService;
import com.qingting.customer.baseserver.MonitorService;
import com.qingting.customer.baseserver.WaterAreaService;
import com.qingting.customer.baseserver.WaterQualityService;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.Filter;
import com.qingting.customer.common.pojo.hbasedo.FilterGroup;
import com.qingting.customer.common.pojo.hbasedo.Formula;
import com.qingting.customer.common.pojo.hbasedo.MicroFormula;
import com.qingting.customer.common.pojo.hbasedo.Monitor;
import com.qingting.customer.common.pojo.hbasedo.WaterArea;
import com.qingting.customer.common.pojo.hbasedo.WaterQuality;
import com.smart.mvc.cache.RedisCache;

public class CacheUtil {
	
	private static RedisCache<Equip> equipRedisCache;//=new RedisCache<Equip>();
	
	private static RedisCache<WaterArea> waterAreaRedisCache;
	
	private static RedisCache<WaterQuality> waterQualityRedisCache;
	
	private static RedisCache<FilterGroup> filterGroupRedisCache;
	
	private static RedisCache<Filter> filterRedisCache;
	
	private static RedisCache<Formula> formulaRedisCache;
	
	private static RedisCache<MicroFormula> microFormulaRedisCache;
	
	private static RedisCache<Monitor> monitorRedisCache;
	
	
	
	private static MonitorService monitorService;
	
	private static EquipService equipService;
	
	private static WaterAreaService waterAreaService;
	
	private static WaterQualityService waterQualityService;
	
	
	private static FilterGroupService filterGroupService;
	
	private static FilterService filterService;
	
	private static FormulaService formulaService;
	
	
	private static MicroFormulaService microFormulaService;
	
	
	
	
	
	//@Autowired 
	public void setEquipRedisCache(RedisCache<Equip> equipRedisCache) {
		CacheUtil.equipRedisCache = equipRedisCache;
	}
	//@Autowired 
	public void setWaterAreaRedisCache(RedisCache<WaterArea> waterAreaRedisCache) {
		CacheUtil.waterAreaRedisCache = waterAreaRedisCache;
	}
	//@Autowired 
	public void setWaterQualityRedisCache(RedisCache<WaterQuality> waterQualityRedisCache) {
		CacheUtil.waterQualityRedisCache = waterQualityRedisCache;
	}
	//@Autowired 
	public void setFilterGroupRedisCache(RedisCache<FilterGroup> filterGroupRedisCache) {
		CacheUtil.filterGroupRedisCache = filterGroupRedisCache;
	}
	//@Autowired 
	public void setFilterRedisCache(RedisCache<Filter> filterRedisCache) {
		CacheUtil.filterRedisCache = filterRedisCache;
	}
	//@Autowired 
	public void setFormulaRedisCache(RedisCache<Formula> formulaRedisCache) {
		CacheUtil.formulaRedisCache = formulaRedisCache;
	}
	//@Autowired 
	public void setMicroFormulaRedisCache(RedisCache<MicroFormula> microFormulaRedisCache) {
		CacheUtil.microFormulaRedisCache = microFormulaRedisCache;
	}
	//@Autowired 
	public void setMonitorRedisCache(RedisCache<Monitor> monitorRedisCache) {
		CacheUtil.monitorRedisCache = monitorRedisCache;
	}
	//@Autowired 
	public void setMonitorService(MonitorService monitorService) {
		CacheUtil.monitorService = monitorService;
	}
	//@Autowired 
	public void setEquipService(EquipService equipService) {
		CacheUtil.equipService = equipService;
	}
	//@Autowired 
	public void setWaterAreaService(WaterAreaService waterAreaService) {
		CacheUtil.waterAreaService = waterAreaService;
	}
	//@Autowired 
	public void setWaterQualityService(WaterQualityService waterQualityService) {
		CacheUtil.waterQualityService = waterQualityService;
	}
	//@Autowired 
	public void setFilterGroupService(FilterGroupService filterGroupService) {
		CacheUtil.filterGroupService = filterGroupService;
	}
	//@Autowired 
	public void setFilterService(FilterService filterService) {
		CacheUtil.filterService = filterService;
	}
	//@Autowired 
	public void setFormulaService(FormulaService formulaService) {
		CacheUtil.formulaService = formulaService;
	}
	//@Autowired 
	public void setMicroFormulaService(MicroFormulaService microFormulaService) {
		CacheUtil.microFormulaService = microFormulaService;
	}
	
	
	//查设备
	public static Equip getEquip(String equipCode){
		System.out.println("equipRedisCache:"+equipRedisCache);
		System.out.println("equipCode:"+equipCode);
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
	public static Filter getFilter(Integer filterId){
		 Filter filter = filterRedisCache.get("filter/"+filterId);
		 if(filter==null){
			 filter=filterService.getById(filterId);
			 filterRedisCache.set("filter/"+filterId,filter);
		 }
		 return filter;
	}
}
