package com.qingting.customer.controller.admin;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.Card;
import com.qingting.customer.model.Equip;
import com.qingting.customer.model.EquipSort;
import com.qingting.customer.model.dto.EquipParamDTO;
import com.smart.mvc.model.Pagination;
import com.qingting.customer.controller.common.QRCodeUtil;
import com.qingting.customer.server.CardService;
import com.qingting.customer.server.EquipService;
import com.qingting.customer.server.EquipSortService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.mvc.util.RandomUtil;
import com.smart.mvc.util.StringUtils;
import com.smart.mvc.validator.Validator;
import com.smart.mvc.validator.annotation.ValidateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "设备相关")
@Controller
@RequestMapping("/admin/equip")
public class EquipController {
	@Resource
	EquipService equipService;
	@Resource
	EquipSortService equipSortService; 
	@Resource
	CardService cardService;
	
	@ApiOperation("页面跳转-设备管理页")
	@RequestMapping(value="/equip",method = RequestMethod.GET,produces="text/html")
	public String equip() {
		return "/admin/equip/equip";
	}
	@ApiOperation("页面跳转-设备添加页")
	@RequestMapping(value="/addEquip",method = RequestMethod.GET,produces="text/html")
	public String addEquip() {
		return "/admin/equip/addEquip";
	}
	@ApiOperation("页面跳转-物联网卡管理页")
	@RequestMapping(value="/card",method = RequestMethod.GET,produces="text/html")
	public String card() {
		return "/admin/equip/card";
	}
	
	@ApiOperation("添加物联网卡")
	@RequestMapping(value="/insertCard",method = RequestMethod.POST)
	public @ResponseBody WebResult<String> insertCard(
			@ApiParam(value = "物联网卡号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String number,
			@ApiParam(value = "运营商分类", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Byte operatorSort
			){
		cardService.insert(new Card(operatorSort,number));
		WebResult<String> result = new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("添加成功");
		return result;
	}
	
	@ApiOperation("查询所有物联网卡")
	@RequestMapping(value="/listCard",method = RequestMethod.GET)
	public @ResponseBody WebResult<Pagination<Card>> listCard(
			@ApiParam(value = "开始页码", required = true) @RequestParam(name="pageNo",required=true) Integer pageNo,
			@ApiParam(value = "显示条数", required = true) @RequestParam(name="pageSize",required=true) Integer pageSize
			){
		Pagination<Card> page = cardService.list(new Pagination<Card>(pageNo,pageSize));
		WebResult<Pagination<Card>> result = new WebResult<Pagination<Card>>(ResultCode.SUCCESS);
		result.setData(page);
		result.setMessage("查询成功");
		return result;
	}
	@ApiOperation("搜索物联网卡")
	@RequestMapping(value="/searchCard",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<Card>> searchCard(
			@ApiParam(value = "物联网卡号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String number
			){
		List<Card> list = cardService.search(number);
		WebResult<List<Card>> result = new WebResult<List<Card>>(ResultCode.SUCCESS);
		result.setData(list);
		result.setMessage("查询成功");
		return result;
	}
	
	@ApiOperation("查询设备分类")
	@RequestMapping(value="/listEquipSort",method = RequestMethod.GET)
	public @ResponseBody WebResult<List<EquipSort>> listEquipSort(
			){
		List<EquipSort> listEquipSort = equipSortService.listEquipSort();
		WebResult<List<EquipSort>> result = new WebResult<List<EquipSort>>(ResultCode.SUCCESS);
		result.setData(listEquipSort);
		result.setMessage("查询成功");
		return result;
	}
	
	@ApiOperation("后台插入设备")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public @ResponseBody WebResult<String> insertEquip(
			@ApiParam(value = "运营商", required = true) @RequestParam @ValidateParam({ Validator.INT })Byte operatorSort,
			@ApiParam(value = "物联网卡号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String cardNumber,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode,
			@ApiParam(value = "账号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String username,
			@ApiParam(value = "密码", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String password
			){
		System.out.println("equipCode:"+equipCode+".username:"+username+".password:"+password);
		cardService.insert(new Card(operatorSort,cardNumber));
		equipService.insertEquip(new Equip(equipCode,cardNumber),username,password);
		WebResult<String> result = new WebResult<String>(ResultCode.SUCCESS);
		result.setData("成功");
		result.setMessage("入库成功");
		return result;
	}
	@ApiOperation("后台删除设备")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> deleteEquipByRowKey(
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode
			){
		System.out.println("设备编号:"+equipCode);
		equipService.deleteEquipByEquipCode(equipCode);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	@ApiOperation("后台更新设备")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public @ResponseBody WebResult<Object> updateEquipByRowKey(
			@ApiParam @RequestBody Equip equip
			){
		equipService.updateEquipByEquipCode(equip);
		return new WebResult<Object>(ResultCode.SUCCESS);
	}
	//已测试OK
	@ApiOperation("查询所有设备")
	@RequestMapping(value="/list",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Pagination<Equip>> listEquip(
			@ApiParam(value = "page", required = true) @RequestBody Pagination<Equip> page
			){
		WebResult<Pagination<Equip>> result=new WebResult<Pagination<Equip>>(ResultCode.SUCCESS);
		result.setData(equipService.listEquipByEquipCodeAndUserId(page));
		return result;
	}
	/*//已测试OK
	@ApiOperation("工程安装-给用户绑定设备")
	@RequestMapping(value="/bindEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> bindEquip(
			@ApiParam(value = "用户ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer userId,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode){
		String msg = equipService.updateUserOfNewEquip(userId, equipCode);
		if(msg==null){//绑定成功
			WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
			result.setMessage("绑定成功");
			return result;
		}else{
			WebResult<Object> result=new WebResult<Object>(ResultCode.FAILURE);
			result.setMessage(msg);
			return result;
		}
			
	}*/
	@ApiOperation("后台用-更新设备的绑定用户")
	@RequestMapping(value="/updateBindEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> updateBindEquip(
			@ApiParam(value = "用户ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer userId,
			@ApiParam(value = "滤芯组合ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer filterGroupId,
			@ApiParam(value = "水源（自来水公司）ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer waterAreaId,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode){
		equipService.updateUserAndRelevanceOfEquip(userId, filterGroupId, waterAreaId, equipCode); 
		
		WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
		result.setMessage("绑定成功");
		return result;
	}
	@ApiOperation("工程安装-给用户绑定设备")
	@RequestMapping(value="/bindEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Object> bindEquip(
			@ApiParam(value = "用户ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer userId,
			@ApiParam(value = "滤芯组合ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer filterGroupId,
			@ApiParam(value = "水源（自来水公司）ID", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })Integer waterAreaId,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode){
		String msg = equipService.updateUserAndRelevanceOfNewEquip(userId, filterGroupId, waterAreaId, equipCode); 
		if(msg==null){//绑定成功
			WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
			result.setMessage("绑定成功");
			return result;
		}else{
			WebResult<Object> result=new WebResult<Object>(ResultCode.FAILURE);
			result.setMessage(msg);
			return result;
		}
	}
	@ApiOperation("获得设备编号等参数")
	@RequestMapping(value="/getEquipParam",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<EquipParamDTO> getEquipParam(
			@ApiParam(value = "包含的编号前缀", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String preCode,
			@ApiParam(value = "开始编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String startCode
			){
		EquipParamDTO equipParamDTO=new EquipParamDTO();
		String equipCode = equipService.getEquipCodeOfNew(preCode);
		if(!StringUtils.isBlank(equipCode)) {//查找到设备
			System.out.println("查找到最新设备code:"+equipCode);
			Long code = Long.valueOf(equipCode);
			String resultCode=String.valueOf(code+1);
			if(resultCode.length()==startCode.length()){
				equipParamDTO.setEquipCode(resultCode);
			}else{
				for(int i=0;i<startCode.length()-resultCode.length();i++){
					resultCode="0"+resultCode;
				}
				equipParamDTO.setEquipCode(resultCode);
			}
			System.out.println("输出code:"+resultCode);
		}else{//未查找到设备
			System.out.println("未查询到库里有设备");
			equipParamDTO.setEquipCode(startCode);
		}
		equipParamDTO.setUsername(RandomUtil.getRandomCode(10));
		equipParamDTO.setPassword(RandomUtil.getRandomCode(10));
		WebResult<EquipParamDTO> result=new WebResult<EquipParamDTO>(ResultCode.SUCCESS);
		result.setData(equipParamDTO);
		result.setMessage("成功");
		return result;
		
		/*if(msg==null){//绑定成功
			WebResult<Object> result=new WebResult<Object>(ResultCode.SUCCESS);
			result.setMessage("绑定成功");
			return result;
		}else{
			WebResult<Object> result=new WebResult<Object>(ResultCode.FAILURE);
			result.setMessage(msg);
			return result;
		}*/
	}
	@ApiOperation("获得二维码图片")
	@RequestMapping(value="/getCodeImage",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public void getCodeImage(
			HttpServletResponse response,
			@ApiParam(value = "设备编号", required = true) @RequestParam @ValidateParam({ Validator.NOT_BLANK })String equipCode,
			@ApiParam(value = "账户", required = false) @RequestParam(name="username",required=false) String username,
			@ApiParam(value = "密码", required = false) @RequestParam(name="password",required=false) String password
			){
		try {
			if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
				System.out.println("用户名或密码空");
				QRCodeUtil.zxingCodeAndTextCreateToResponse(equipCode,equipCode, 200,200, "jpg",response.getOutputStream());
			}else{
				System.out.println("用户名和密码非空");
				QRCodeUtil.zxingCodeAndTextCreateToResponse(equipCode+"/"+username+"/"+password,equipCode, 200,200, "jpg",response.getOutputStream());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
