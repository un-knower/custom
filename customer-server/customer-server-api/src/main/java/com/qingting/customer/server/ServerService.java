package com.qingting.customer.server;

import java.util.List;

import com.qingting.customer.model.SummaryServer;

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
	List<SummaryServer> listSummaryServerByUserId(Integer userId);
}
