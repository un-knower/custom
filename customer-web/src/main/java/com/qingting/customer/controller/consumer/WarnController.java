package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.baseserver.WarnService;
import com.qingting.customer.common.pojo.dto.WarnDTO;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "预警相关")
@Controller("consumerWarnController")
@RequestMapping("/consumer/warn")
public class WarnController {
	@Resource
	WarnService warnService;
	
	/*@ApiOperation("查询设备的预警")
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Warn>> listWarn(
			@ApiParam(value = "设备ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipId
			){
		List<Warn> list = warnService.listWarn(equipId);
		WebResult<List<Warn>> result=new WebResult<List<Warn>>(ResultCode.SUCCESS);
		result.setData(list);
		return result;
	}*/
	@ApiOperation("查询设备的预警类型")
	@RequestMapping(value="/getWarnType",method = RequestMethod.GET)
	public @ResponseBody WebResult<String> getWarnType(
			@ApiParam(value = "设备ID", required = false) @RequestParam(value="equipId", required=false) String equipId
			){
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setData("2");
		return result;
	}
	@ApiOperation("查询预警消息")
	@RequestMapping(value="/listWarn",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<WarnDTO>> listWarn(
			){
		List<WarnDTO> list = new ArrayList<WarnDTO>();
		WebResult<List<WarnDTO>> result=new WebResult<List<WarnDTO>>(ResultCode.SUCCESS);
		WarnDTO w1=new WarnDTO();
		w1.setEquipName("小小清渟");
		w1.setFlow(654987.0f);
		w1.setHumidity(45f);
		w1.setLeak(true);
		w1.setPath("/resource/images/customer/equip/xqt.jpg");
		w1.setPurTds(17.5f);
		w1.setRawTds(76.0f);
		w1.setTemp(12.3f);
		w1.setEquipCode("cdzb201706270052");
		w1.setAddress("四川成都高新西区天全路222号 无线通信国家专业化众创空间2号楼8楼整层");
		list.add(w1);
		WarnDTO w2=new WarnDTO();
		w2.setEquipName("小清渟");
		w2.setFlow(5453.0f);
		w2.setHumidity(63f);
		w2.setLeak(false);
		w2.setPath("/resource/images/customer/equip/xxqt.png");
		w2.setPurTds(12.5f);
		w2.setRawTds(125.0f);
		w2.setTemp(34.3f);
		w2.setEquipCode("cdzb201706270053");
		w2.setAddress("四川成都高新西区天全路222号 无线通信国家专业化众创空间2号楼8楼整层");
		list.add(w2);
		
		result.setData(list);
		return result;
	}
}
