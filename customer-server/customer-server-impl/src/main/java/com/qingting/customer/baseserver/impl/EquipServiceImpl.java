package com.qingting.customer.baseserver.impl;


import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingting.customer.baseserver.EquipService;
import com.qingting.customer.baseserver.common.CacheUtil;
import com.qingting.customer.baseserver.common.HttpRequestEntityUtils;
import com.qingting.customer.common.pojo.common.AttentStatus;
import com.qingting.customer.common.pojo.common.FindEquipType;
import com.qingting.customer.common.pojo.common.MessageStatus;
import com.qingting.customer.common.pojo.hbasedo.Attention;
import com.qingting.customer.common.pojo.hbasedo.Equip;
import com.qingting.customer.common.pojo.hbasedo.EquipSort;
import com.qingting.customer.common.pojo.hbasedo.Message;
import com.qingting.customer.common.pojo.model.Pagination;
import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.dao.EquipSortDAO;
import com.qingting.customer.dao.MessageDAO;
import com.qingting.operation.enums.MessageType;
import com.qingting.platform.common.Result;
import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.model.ResultCode;
import com.smart.mvc.model.WebResult;

@Service("equipService")
public class EquipServiceImpl implements EquipService,com.qingting.operation.server.EquipService{
	@Resource
	EquipDAO equipDAO;
	@Resource
	MessageDAO messageDAO;
	@Resource
	EquipSortDAO equipSortDAO; 
	
	private static String iotAddress = ConfigUtils.getProperty("iot.server");
	
	@Override
	public WebResult<String> insertEquip(Equip equip,String username,String password) {
		WebResult<String> result=null;
		try {
			String jsonString=HttpRequestEntityUtils.post(
					iotAddress+"/equip/addEquip","equipCode="+equip.getEquipCode()+"&username="+username+"&password="+password	
					);
			JSONObject parseObject = JSON.parseObject(jsonString);
			
			result=new WebResult<String>();
			result.setCode((int)parseObject.get("code"));
			result.setData((String)parseObject.get("data"));
			result.setMessage((String)parseObject.get("message"));
			
			if( result.getCode()==ResultCode.SUCCESS ){
				equipDAO.insertEquip(equip);
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
	}
	
	@Override
	public Pagination<Equip> listEquipByEquipCodeAndUserId(Pagination<Equip> page) {
		return equipDAO.listEquipByEquipCodeAndUserId(page);
	}

	@Override
	public void deleteEquipByEquipCode(String equipCode) {
		equipDAO.deleteEquipByEquipCode(equipCode);
	}

	@Override
	public void addAttent(Integer userId,String userName, String equipCode) {
		Equip equip=equipDAO.getEquip(equipCode);
		EquipSort equipSort = equipSortDAO.getEquipSortById(equip.getEquipSortId());
		
		Message message=new Message();
		message.setContent("申请关注你的饮水设备,备注:"+equip.getEquipMark());
		message.setImageUrl(equipSort.getImageUrl());
		message.setReadFlag(false);
		message.setType(MessageType.APPLY_ATTENT.getType());
		message.setStatus(MessageStatus.SQGZ_WAIT_HANDLE.getStatus());
		message.setTitle(userName);
		message.setUserId(equip.getUserId());//这里是接收消息的用户
		message.setDetailId(userId);//这里是发送消息的用户
		message.setStrParam(equipCode);
		
		Attention attention = new Attention();
		attention.setCreateTime(Calendar.getInstance());
		attention.setEquipCode(equipCode);
		attention.setIsTop(false);
		attention.setStatus(AttentStatus.CHECK.getValue());
		attention.setUserId(userId);
		//第一步:给设备所属用户发送申请消息
		messageDAO.insertMessage(message);
		//第二步:添加关注设备信息
		
		equipDAO.insertAttent(attention);
	}



	@Override
	public void updateUserOfEquip(Integer userId, String equipCode) {
		equipDAO.updateUserOfEquip(userId, equipCode);
	}



	@Override
	public String updateUserOfNewEquip(Integer userId, String equipCode) {
		return equipDAO.updateUserOfNewEquip(userId, equipCode);
	}



	@Override
	public void updateEquipByEquipCode(Equip equip) {
		equipDAO.updateEquipByEquipCode(equip);
	}



	@Override
	public List<Equip> listEquip(Integer userId,String type) {
		if(type.equals(FindEquipType.MINE.getType()))
			return equipDAO.listEquip(userId);
		else if(type.equals(FindEquipType.ATTENT.getType()))
			return equipDAO.listAttentEquip(userId);
		else
			return null;
	}



	@Override
	public Equip getEquip(String equipCode) {
		return equipDAO.getEquip(equipCode);
	}



	@Override
	public List<Equip> searchEquip(String equipCode) {
		return equipDAO.searchEquip(equipCode);
	}

	@Override
	public boolean checkIsOpen(String equipCode) {
		return equipDAO.checkIsOpen(equipCode);
	}
	
	@Override
	public Boolean setOpen(String equipCode, Boolean isOpen) {
		return equipDAO.setOpen(equipCode, isOpen);
	}


	@Override
	public void attentHandle(Long messageId,Integer userId,String equipCode,byte status,Integer userSelfId) {
		equipDAO.attentHandle(userId, equipCode, status);
		if(status==AttentStatus.PASS.getValue())
			messageDAO.setStatus(userSelfId, MessageType.APPLY_ATTENT.getType(), messageId, MessageStatus.SQGZ_ALREADY_AGREE.getStatus());
		else if(status==AttentStatus.REFUSE.getValue())
			messageDAO.setStatus(userSelfId, MessageType.APPLY_ATTENT.getType(), messageId, MessageStatus.SQGZ_ALREADY_REFUSE.getStatus());
	}


	



	@Override
	public void deleteAttent(Integer userId, String equipCode) {
		equipDAO.deleteAttent(userId, equipCode);
	}



	@Override
	public Equip getTopEquip(Integer userId) {
		return equipDAO.getTopEquip(userId);
	}



	@Override
	public void setTop(Integer userId, String type, String equipCode) {
		equipDAO.setTop(userId, type, equipCode);
	}

	@Override
	public List<Attention> listAttent(Integer userId) {
		return equipDAO.listAttent(userId);
	}

	@Override
	public List<Equip> listAttentEquip(Integer userId) {
		return equipDAO.listAttentEquip(userId);
	}

	@Override
	public int countAttent(Integer userId) {
		return equipDAO.countAttent(userId);
	}

	@Override
	public int countEquip(Integer userId) {
		return equipDAO.countEquip(userId);
	}

	@Override
	public void updateUserAndRelevanceOfEquip(Integer userId, Integer filterGroupId, Integer waterAreaId,
			String equipCode) {
		CacheUtil.clearEquip(equipCode);
		equipDAO.updateUserAndRelevanceOfEquip(userId, filterGroupId, waterAreaId, equipCode);
	}

	@Override
	public String updateUserAndRelevanceOfNewEquip(Integer userId, Integer filterGroupId, Integer waterAreaId,
			String equipCode) {
		CacheUtil.clearEquip(equipCode);
		return equipDAO.updateUserAndRelevanceOfNewEquip(userId, filterGroupId, waterAreaId, equipCode);
	}

	@Override
	public String getEquipCodeOfNew() {
		return equipDAO.getEquipCodeOfNew();
	}
	
	
	@Override
	public Result bindEquip(Integer userId, Integer filterGroupId, Integer waterAreaId, String equipCode) {
		String str = equipDAO.updateUserAndRelevanceOfNewEquip(userId, filterGroupId, waterAreaId, equipCode);
		if(str==null){
			return Result.createSuccessResult();
		}else{
			Result result = Result.createFailureResult();
			result.setMessage(str);
			return result;
		}
	}
}
