package com.qingting.customer.server.external;

import com.smart.mvc.model.Result;

public interface TxMessageService {
	/**
	 * 
	 * @Title: getValidateCode
	 * @Description: 获得验证码
	 * @param account
	 * @param ip
	 * @return 
	 * @return Result
	 * @throws
	 */
	Result getValidateCode(String account,String ip);
}
