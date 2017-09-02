package com.qingting.operation.server.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingting.customer.dao.EquipDAO;
import com.qingting.customer.dao.EquipSortDAO;
import com.qingting.customer.model.Equip;
import com.qingting.customer.model.EquipSort;
import com.qingting.customer.model.dto.SummaryServerDTO;
import com.qingting.customer.server.ServerService;
import com.qingting.operation.model.ServerDTO;

@Service("customerServerService")
public class ServerServiceImpl implements ServerService {
	@Resource
	com.qingting.operation.server.ServerService operationServerService;
	@Resource
	EquipDAO equipDAO;
	@Resource
	EquipSortDAO equipSortDAO;
	@Override
	public List<SummaryServerDTO> listSummaryServerByUserId(Integer userId) {
		
		/*List<ServerDTO> serverDTOs= operationServerService.listServerDTOByUserId(userId);
		List<SummaryServer> summaryServers=new ArrayList<SummaryServer>();
		for (ServerDTO serverDTO : serverDTOs) {
			SummaryServer summaryServer = new SummaryServer();
			summaryServer.setServer(serverDTO);
			
			Equip equip = equipDAO.getEquipById(serverDTO.getEquipId());
			summaryServer.setEquipMark(equip.getEquipMark());
			
			EquipSort equipSort = equipSortDAO.getEquipSortById(equip.getEquipSortId());
			summaryServer.setEquipSortImage(equipSort.getSortImage());
			
			summaryServers.add(summaryServer);
		}
		return summaryServers;*/
		System.out.println("=========listSummaryServerByUserId=========");
		return null;
	}

}
