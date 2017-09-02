package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.model.dto.SummaryServerDTO;

public interface ServerService {
	/**
	 * 
	 * @Title: listSummaryServerByUserId
	 * @Description: 查服务记录列表
	 * @param userId
	 * @return 
	 * @return List<SummaryServer>
	 * @throws
	 */
	List<SummaryServerDTO> listSummaryServerByUserId(Integer userId);
}
