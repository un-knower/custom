package com.qingting.customer.common.pojo.hbasedo;

import java.util.Calendar;

/**
 * 
 * @ClassName: Extra
 * @Description: 保障和特权
 * @author zlf
 * @date 2017年5月15日 下午6:31:15
 *
 */
public class Extra {
	private String rowKey;
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Calendar calendar;
	/**
	 * 数据的版本
	 */
	private final Byte version = 0;
}
