package com.qingting.customer.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.dto.EquipCountDTO;
import com.qingting.customer.model.dto.EquipDetailDTO;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "分布图监控")
@Controller
@RequestMapping("/admin/map")
public class MapController {
	@ApiOperation("全国设备分布数据")
	@RequestMapping(value="/listProvinceEquip",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<EquipCountDTO>> listProvinceEquip(){
		List<EquipCountDTO> list=new ArrayList<EquipCountDTO>();
		EquipCountDTO cd1=new EquipCountDTO();
		cd1.setCode("510000");
		cd1.setName("四川省");
		cd1.setEquipCount(25);
		cd1.setWarnCount(10);
		cd1.setLng(102.89916f);
		cd1.setLat(30.367481f);
		EquipCountDTO cd2=new EquipCountDTO();
		cd2.setCode("430000");
		cd2.setName("湖南省");
		cd2.setEquipCount(25);
		cd2.setWarnCount(10);
		cd2.setLng(111.720664f);
		cd2.setLat(27.695864f);
		list.add(cd1);
		list.add(cd2);
		WebResult<List<EquipCountDTO>> result=new WebResult<List<EquipCountDTO>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
	@ApiOperation("市设备分布数据")
	@RequestMapping(value="/listCityEquip",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<EquipCountDTO>> listCityEquip(
			@ApiParam(value = "省编码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String provinceCode
			){
		List<EquipCountDTO> list=new ArrayList<EquipCountDTO>();
		EquipCountDTO cd1=new EquipCountDTO();
		cd1.setCode("510000");
		cd1.setName("四川省");
		cd1.setEquipCount(25);
		cd1.setWarnCount(10);
		cd1.setLng(102.89916f);
		cd1.setLat(30.367481f);
		EquipCountDTO cd2=new EquipCountDTO();
		cd2.setCode("430000");
		cd2.setName("湖南省");
		cd2.setEquipCount(25);
		cd2.setWarnCount(10);
		cd2.setLng(111.720664f);
		cd2.setLat(27.695864f);
		list.add(cd1);
		list.add(cd2);
		WebResult<List<EquipCountDTO>> result=new WebResult<List<EquipCountDTO>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
	@ApiOperation("设备分布数据")
	@RequestMapping(value="/listEquipCount",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<EquipCountDTO>> listEquipCount(
			@ApiParam(value = "编码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String code
			){
		List<EquipCountDTO> list=new ArrayList<EquipCountDTO>();
		EquipCountDTO cd1=new EquipCountDTO();
		cd1.setCode("510000");
		cd1.setName("四川省");
		cd1.setEquipCount(25);
		cd1.setWarnCount(10);
		cd1.setLng(102.89916f);
		cd1.setLat(30.367481f);
		EquipCountDTO cd2=new EquipCountDTO();
		cd2.setCode("430000");
		cd2.setName("湖南省");
		cd2.setEquipCount(25);
		cd2.setWarnCount(10);
		cd2.setLng(111.720664f);
		cd2.setLat(27.695864f);
		list.add(cd1);
		list.add(cd2);
		WebResult<List<EquipCountDTO>> result=new WebResult<List<EquipCountDTO>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
	@ApiOperation("设备详细分布数据")
	@RequestMapping(value="/listEquipDetail",method = RequestMethod.POST)
	public @ResponseBody WebResult<List<EquipDetailDTO>> listEquipDetail(){
		List<EquipDetailDTO> list = new ArrayList<EquipDetailDTO>();
		EquipDetailDTO ed1=new EquipDetailDTO();
		ed1.setCode("510000");
		ed1.setName("四川省");
		ed1.setLng(111.720664f);
		ed1.setLat(27.695864f);
		EquipDetailDTO ed2=new EquipDetailDTO();
		ed2.setCode("430000");
		ed2.setName("湖南省");
		ed2.setLng(111.720664f);
		ed2.setLat(27.695864f);
		list.add(ed1);
		list.add(ed2);
		WebResult<List<EquipDetailDTO>> result=new WebResult<List<EquipDetailDTO>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}
}	
