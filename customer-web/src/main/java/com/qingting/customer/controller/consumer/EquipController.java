package com.qingting.customer.controller.consumer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingting.customer.model.common.AttentStatus;
import com.qingting.customer.model.common.FindEquipType;
import com.qingting.customer.model.dto.EquipDTO;
import com.qingting.customer.model.hbasedo.Equip;
import com.qingting.customer.model.hbasedo.User;
import com.qingting.customer.model.util.DateUtil;
import com.qingting.customer.controller.common.SessionUserMsg;
import com.qingting.customer.controller.common.SessionUserMsgUtils;
import com.qingting.customer.server.EquipService;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;
import com.smart.sso.client.SessionUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "设备相关")
@Controller("consumerEquipController")
@RequestMapping("/consumer/equip")
public class EquipController {
	/*private static boolean e1Stick=true;
	private static boolean e2Stick=false;
	private static boolean e1Open=true;
	private static boolean e2Open=false;
	private static String e1Code="cdzb201706270052";
	private static String e2Code="cdzb201706270053";
	private static boolean e3Stick=true;
	private static boolean e4Stick=false;
	private static boolean e3Open=true;
	private static boolean e4Open=false;
	private static String e3Code="cdzb201706270054";
	private static String e4Code="cdzb201706270055";
	private static boolean e3delete=false;
	private static boolean e4delete=false;*/
	@Resource
	EquipService equipService;
	//已测试OK
	@ApiOperation("查询所有设备")
	@RequestMapping(value="/list",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<List<EquipDTO>> listEquip(
			HttpServletRequest request,
			@ApiParam(value = "设备类型,mine(我的)或attent(关注的)", required = true) @RequestParam String type){
		
		/*if(projectId!=0){
			List<Equip> list = equipService.listEquipByProjectId(projectId);
			result=new WebResult<List<Equip>>(ResultCode.SUCCESS);
			result.setData(list);
		}else{
			SessionUserMsg sessionUser = SessionUtils.getSessionUserMsg(request);
			User user = (User)sessionUser.getProfile();
			List<Equip> list = equipService.listEquipByUserId(user.getId());
			result=new WebResult<List<Equip>>(ResultCode.SUCCESS);
			result.setData(list);
		}*/
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		
		List<EquipDTO> list =new ArrayList<EquipDTO>();
		List<Equip> listEquip = equipService.listEquip(user.getId(), type);
		
		/*if(type.equals("mine")){
			EquipDTO e1=new EquipDTO();
			e1.setAddress("四川成都高新西区天全路222号 无线通信国家专业化众创空间2号楼8楼整层");
			e1.setEquipCode(e1Code);
			e1.setEquipMark("清渟科技茶水间");
			e1.setMonitorCount(124568l);
			e1.setOpen(e1Open);
			e1.setPath("/resource/images/customer/equip/xqt.jpg");
			e1.setPurTds(12.0f);
			Calendar calendar1=DateUtil.getDate(2017,1,1,0,0,0);
			e1.setRemainTime(Calendar.getInstance().getTimeInMillis()-calendar1.getTimeInMillis());
			e1.setServiceCount(4);
			e1.setSortName("小清渟");
			e1.setStickFlag(e1Stick);
			list.add(e1);
			EquipDTO e2=new EquipDTO();
			e2.setAddress("四川省成都市郫县犀浦镇樟菊园3幢2单元1201");
			e2.setEquipCode(e2Code);
			e2.setEquipMark("自己家饮水机");
			e2.setMonitorCount(34561l);
			e2.setOpen(e2Open);
			e2.setPath("/resource/images/customer/equip/xxqt.png");
			e2.setPurTds(6.20f);
			Calendar calendar2=DateUtil.getDate(2017,1,1,0,0,0);
			e2.setRemainTime(Calendar.getInstance().getTimeInMillis()-calendar2.getTimeInMillis());
			e2.setServiceCount(10);
			e2.setSortName("小小清渟");
			e2.setStickFlag(e2Stick);
			list.add(e2);
		}else if(type.equals("attent")){
			if(e3delete==false){
				EquipDTO e3=new EquipDTO();
				e3.setAddress("上海市浦东新区金睦路353弄海尚东苑28号601室");
				e3.setEquipCode(e3Code);
				e3.setEquipMark("上海伯父家");
				e3.setMonitorCount(124568l);
				e3.setOpen(e3Open);
				e3.setPath("/resource/images/customer/equip/xqt.jpg");
				e3.setPurTds(12.0f);
				Calendar calendar1=DateUtil.getDate(2017,1,1,0,0,0);
				e3.setRemainTime(Calendar.getInstance().getTimeInMillis()-calendar1.getTimeInMillis());
				e3.setServiceCount(4);
				e3.setSortName("小清渟");
				e3.setStickFlag(e3Stick);
				list.add(e3);
			}
			if(e4delete==false){
				EquipDTO e4=new EquipDTO();
				e4.setAddress("北京市昌平区东小口镇小辛庄村478公交总站");
				e4.setEquipCode(e4Code);
				e4.setEquipMark("武双家");
				e4.setMonitorCount(34561l);
				e4.setOpen(e4Open);
				e4.setPath("/resource/images/customer/equip/xxqt.png");
				e4.setPurTds(6.20f);
				Calendar calendar2=DateUtil.getDate(2017,1,1,0,0,0);
				e4.setRemainTime(Calendar.getInstance().getTimeInMillis()-calendar2.getTimeInMillis());
				e4.setServiceCount(10);
				e4.setSortName("小小清渟");
				e4.setStickFlag(e4Stick);
				list.add(e4);
			}
		}*/
		WebResult<List<EquipDTO>> result=null;
		if(listEquip!=null && listEquip.size()>0){
			for (Equip equip : listEquip) {
				EquipDTO equipDTO=new EquipDTO();
				
				equipDTO.setAddress(equip.getAddress());
				equipDTO.setEquipCode(equip.getEquipCode());
				equipDTO.setEquipMark(equip.getEquipMark());
				equipDTO.setIsOpen(equip.getIsOpen());
				equipDTO.setIsTop(equip.getIsTop());
				equipDTO.setMonitorCount(12252l);//这里需要查询
				equipDTO.setPath("/resource/images/customer/equip/xqt.jpg");//这里需要查询
				equipDTO.setPurTds(6.2f);//这里需要？
				//这里需要查询
				Calendar calendar1=DateUtil.getDate(2017,1,1,0,0,0);
				equipDTO.setRemainTime(Calendar.getInstance().getTimeInMillis()-calendar1.getTimeInMillis());
				equipDTO.setServiceCount(4);
				equipDTO.setSortName("小清渟");//这里需要查询
				
				list.add(equipDTO);
			}
			result=new WebResult<List<EquipDTO>>(ResultCode.SUCCESS);
			result.setMessage("查询成功");
			result.setData(list);
		}else{
			result=new WebResult<List<EquipDTO>>(ResultCode.FAILURE);
			if(type.equals(FindEquipType.MINE.getType()))
				result.setMessage("你还没有设备额~");
			else if(type.equals(FindEquipType.ATTENT.getType()))
				result.setMessage("目前还没有关注的设备~");
			else
				result.setMessage("类型(type)错误");
		}
		
		return result;
	}
	//已测试OK
	@ApiOperation("设置设备是否公开")
	@RequestMapping(value="/setIsOpen",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> setIsOpen(
			HttpServletRequest request,
			@ApiParam(value = "设备编号", required = true) @RequestParam String equipCode,
			@ApiParam(value = "非否公开,true:公开,false:不公开", required = true) @RequestParam Boolean isOpen
			){
		
		/*if(open==true){
			result.setData("true");
		}else{
			result.setData("false");
		}
		
		if(equipCode.equals(e1Code))
			e1Open=open;
		else if(equipCode.equals(e2Code))
			e2Open=open;*/
		WebResult<String> result=null;
		if(equipService.setOpen(equipCode, isOpen)){
			result=new WebResult<String>(ResultCode.SUCCESS);
			result.setMessage("设置成功");
		}else{
			result=new WebResult<String>(ResultCode.FAILURE);
			result.setMessage("设置失败");
		}
		return result;
	}
	//已测试OK
	@ApiOperation("设置设备置顶")
	@RequestMapping(value="/setTop",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> setTop(
			HttpServletRequest request,
			@ApiParam(value = "设备类型,mine(我的)或attent(关注的)", required = true) @RequestParam String type,
			@ApiParam(value = "设备编号", required = true) @RequestParam String equipCode
			){
		
		/*if(type.equals("mine")){
			if(equipCode.equals(e1Code)){
				e1Stick=true;
				e2Stick=false;
			}else if(equipCode.equals(e2Code)){
				e1Stick=false;
				e2Stick=true;
			}
		}else if(type.equals("attent")){
			if(equipCode.equals(e3Code)){
				e3Stick=true;
				e4Stick=false;
			}else if(equipCode.equals(e4Code)){
				e3Stick=false;
				e4Stick=true;
			}
		}*/
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		equipService.setTop(user.getId(), type, equipCode);
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("设置成功");
		result.setData(equipCode);
		return result;
	}
	@ApiOperation("删除关注")
	@RequestMapping(value="/deleteAttent",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> deleteAttent(
			HttpServletRequest request,
			@ApiParam(value = "设备编号", required = true) @RequestParam String equipCode
			){
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		equipService.deleteAttent(user.getId(), equipCode);
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("删除成功");
		/*if(equipCode.equals(e3Code)){
			e3delete=true;
		}else if(equipCode.equals(e4Code)){
			e4delete=true;
		}*/
		result.setData(equipCode);
		return result;
	}
	@ApiOperation("关注处理")
	@RequestMapping(value="/attentHandle",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> attentHandle(
			HttpServletRequest request,
			@ApiParam(value = "消息ID", required = true) @RequestParam Long id,
			@ApiParam(value = "用户ID", required = true) @RequestParam Integer userId,
			@ApiParam(value = "设备编号", required = true) @RequestParam String equipCode,
			@ApiParam(value = "是否同意,0:待审核  1:通过  2:拒绝  ", required = true) @RequestParam Byte status
			){
		WebResult<String> result=null;
		if(/*status==AttentStatus.CHECK.getValue() || */
				status==AttentStatus.PASS.getValue() || 
				status==AttentStatus.REFUSE.getValue()){
			SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
			User user = (User)sessionUserMsg.getProfile();
			//这里应该是申请的用户
			equipService.attentHandle(id,userId, equipCode, status,user.getId());
			result=new WebResult<String>(ResultCode.SUCCESS);
			result.setMessage("处理成功");
		}else{
			result=new WebResult<String>(ResultCode.FAILURE);
			result.setMessage("状态参数status不在有效范围");
		}
		/*if(agree==true){
			e3delete=false;
			result.setMessage("已同意");
		}else{
			result.setCode(ResultCode.FAILURE);
			result.setMessage("已拒绝");
		}*/
		//result.setData();
		return result;
	}
	@ApiOperation("添加关注")
	@RequestMapping(value="/addAttent",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<String> addAttent(
			HttpServletRequest request,
			@ApiParam(value = "设备编号", required = true) @RequestParam String equipCode
			){
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		
		equipService.addAttent(user.getId(), user.getName(), equipCode);
		
		WebResult<String> result=new WebResult<String>(ResultCode.SUCCESS);
		result.setMessage("添加成功");
		/*if(equipCode.equals(e3Code)){
			e3delete=false;
		}else if(equipCode.equals(e4Code)){
			e4delete=false;
		}else{
			result.setCode(ResultCode.FAILURE);
			result.setMessage("添加失败");
		}*/
		result.setData(equipCode);
		return result;
	}
	//已测试OK
	@ApiOperation("搜索设备")
	@RequestMapping(value="/searchEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<List<EquipDTO>> searchEquip(
			HttpServletRequest request,
			@ApiParam(value = "设备编号", required = true) @RequestParam String equipCode
			){
		System.out.println("equipCode:"+equipCode);
		
		List<EquipDTO> list =new ArrayList<EquipDTO>();
		/*if(e3Code.contains(equipCode)){
			EquipDTO e3=new EquipDTO();
			e3.setAddress("上海市浦东新区金睦路353弄海尚东苑28号601室");
			e3.setEquipCode(e3Code);
			e3.setEquipMark("上海伯父家");
			e3.setMonitorCount(124568l);
			e3.setOpen(e3Open);
			e3.setPath("/resource/images/customer/equip/xqt.jpg");
			e3.setPurTds(12.0f);
			Calendar calendar1=DateUtil.getDate(2017,1,1,0,0,0);
			e3.setRemainTime(Calendar.getInstance().getTimeInMillis()-calendar1.getTimeInMillis());
			e3.setServiceCount(4);
			e3.setSortName("小清渟");
			e3.setStickFlag(e3Stick);
			list.add(e3);
		}else if(e4Code.contains(equipCode)){
			EquipDTO e4=new EquipDTO();
			e4.setAddress("北京市昌平区东小口镇小辛庄村478公交总站");
			e4.setEquipCode(e4Code);
			e4.setEquipMark("武双家");
			e4.setMonitorCount(34561l);
			e4.setOpen(e4Open);
			e4.setPath("/resource/images/customer/equip/xxqt.png");
			e4.setPurTds(6.20f);
			Calendar calendar2=DateUtil.getDate(2017,1,1,0,0,0);
			e4.setRemainTime(Calendar.getInstance().getTimeInMillis()-calendar2.getTimeInMillis());
			e4.setServiceCount(10);
			e4.setSortName("小小清渟");
			e4.setStickFlag(e4Stick);
			list.add(e4);
		}else{
			result.setCode(ResultCode.FAILURE);
			result.setMessage("未找到设备");
		}*/
		List<Equip> searchEquip = equipService.searchEquip(equipCode);
		
		WebResult<List<EquipDTO>> result=null;
		if(searchEquip!=null && searchEquip.size()>0){
			for (Equip equip : searchEquip) {
				EquipDTO equipDTO=new EquipDTO();
				equipDTO.setAddress(equip.getAddress());
				equipDTO.setEquipCode(equip.getEquipCode());
				equipDTO.setEquipMark(equip.getEquipMark());
				equipDTO.setIsOpen(equip.getIsOpen());
				list.add(equipDTO);
				//equipDTO.setIsTop(equip.getIsTop());
				//equipDTO.setMonitorCount(12252l);//这里需要查询
				//equipDTO.setPath("/resource/images/customer/equip/xqt.jpg");//这里需要查询
				//equipDTO.setPurTds(6.2f);//这里需要？
				//equipDTO.
			}
			result=new WebResult<List<EquipDTO>>(ResultCode.SUCCESS);
			result.setData(list);
			result.setMessage("找到设备");
		}else{
			result=new WebResult<List<EquipDTO>>(ResultCode.FAILURE);
			result.setMessage("未找到设备");
		}
		return result;
	}
	@ApiOperation("统计我的设备")
	@RequestMapping(value="/countEquip",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Integer> countEquip(
			HttpServletRequest request
			){
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		
		WebResult<Integer> result=null;
		Integer num=equipService.countEquip(user.getId());
		if(num!=null){
			result=new WebResult<Integer>(ResultCode.SUCCESS);
			result.setMessage("查询成功");
			result.setData(num);
		}/*else{
			result=new WebResult<Integer>(ResultCode.FAILURE);
			result.setMessage("服务器异常");
		}*/
		return result;
	}
	@ApiOperation("统计关注的设备")
	@RequestMapping(value="/countAttent",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public @ResponseBody WebResult<Integer> countAttent(
			HttpServletRequest request
			){
		SessionUserMsg sessionUserMsg = SessionUserMsgUtils.getSessionUserMsg(request);
		User user = (User)sessionUserMsg.getProfile();
		
		WebResult<Integer> result=null;
		Integer num=equipService.countAttent(user.getId());
		if(num!=null){
			result=new WebResult<Integer>(ResultCode.SUCCESS);
			result.setMessage("查询成功");
			result.setData(num);
		}/*else{
			result=new WebResult<Integer>(ResultCode.FAILURE);
			result.setMessage("服务器异常");
		}*/
		return result;
	}
}
