package com.qingting.customer.common.pojo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(DateUtil.class);
	// 系统设定的开始计数的时间
	// 年
	private static final int year = 2017;
	// 月
	private static final int month = 1;
	// 日
	private static final int date = 1;
	// 时
	private static final int hourOfDay = 0;
	// 分
	private static final int minute = 0;
	// 秒
	private static final int second = 0;
	//项目启动时间常量
	private static final Calendar START = Calendar.getInstance();
	static {
		//初始化启动时间
		// 注意系统月份是从0~11，即0~1月，11~12月
		START.set(year, month - 1, date, hourOfDay, minute, second);
	}
	public static long getBeforOfTime(Calendar calendar){
		Date d=null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("1970-01-01 00:00:30 000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar.getTimeInMillis() - d.getTime();
	}
	/**
	 * 
	 * @Title: getStart
	 * @Description: 获得项目启动时间常量START
	 * @return 
	 * @return Calendar
	 * @throws
	 */
	public static Calendar getStart(){
		return START;
	}
	public static long getStartOfMillis(){
		return START.getTimeInMillis();
	}
	/**
	 * 
	 * @Title: convert
	 * @Description: date类型的Calendar包装
	 * @param date
	 * @return 
	 * @return Calendar
	 * @throws
	 */
	public static Calendar convert(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	/**
	 * 
	 * @Title: getDate
	 * @Description: 获得一个指定年月日+固定00:00:00 000的时间对象
	 * @param year
	 * @param month
	 * @param date
	 * @return 
	 * @return Calendar
	 * @throws
	 */
	public static Calendar getDate(int year, int month, int date) {
		Date d = null;
		try {
			d = new SimpleDateFormat("HH:mm:ss SSS").parse("00:00:00 000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(year, month - 1, date);
		return cal;
	}
	/**
	 * 
	 * @Title: getDate
	 * @Description: 获得一个指定年月日时分秒+固定000毫秒的时间对象
	 * @param year
	 * @param month
	 * @param date
	 * @param hourOfDay
	 * @param minute
	 * @param second
	 * @return 
	 * @return Calendar
	 * @throws
	 */
	public static Calendar getDate(int year, int month, int date,
			int hourOfDay, int minute, int second) {
		Date d = null;
		try {
			d = new SimpleDateFormat("SSS").parse("000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(year, month - 1, date, hourOfDay, minute, second);
		return cal;
	}
	/**
	 * 
	 * @Title: getDate
	 * @Description: 获得一个指定年月日时分秒毫秒的时间对象
	 * @param year
	 * @param month
	 * @param date
	 * @param hourOfDay
	 * @param minute
	 * @param second
	 * @param millis
	 * @return 
	 * @return Calendar
	 * @throws
	 */
	public static Calendar getDate(int year, int month, int date,
			int hourOfDay, int minute, int second, int millis) {
		Date d = null;
		try {
			d = new SimpleDateFormat("SSS").parse(String.valueOf(millis));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(year, month - 1, date, hourOfDay, minute, second);
		return cal;
	}

	/**
	 * 
	 * @Title: getDayOfStart
	 * @Description: 获得从开始计数到现在时间的天数
	 * @return 
	 * @return short
	 * @throws
	 */
	public static short getDayOfStart() {
		Calendar calendar = Calendar.getInstance();
		long temp = (calendar.getTimeInMillis() - START.getTimeInMillis())
				/ (24 * 60 * 60 * 1000);
		logger.debug("距离开始计数天数：" + temp);
		if (temp > 65535)
			return (short) (temp % 65535);
		else
			return (short) temp;
	}

	/**
	 * 
	 * @Title: getDayOfStart
	 * @Description: 获得从开始计数到给定时间的天数
	 * @param calendar
	 * @return 
	 * @return short
	 * @throws
	 */
	public static short getDayOfStart(Calendar calendar) {
		long temp = (calendar.getTimeInMillis() - START.getTimeInMillis())
				/ (24 * 60 * 60 * 1000);
		logger.debug("距离开始计数天数：" + temp);
		if (temp > 65535)
			return (short) (temp % 65535);
		else
			return (short) temp;
	}

	/**
	 * 
	 * @Title: getDayOfGMT
	 * @Description: 返回距离GMT(1970年1月1日00:00:00.000 GMT)时间的天数
	 * @return 
	 * @return short
	 * @throws
	 */
	public static short getDayOfGMT() {
		Calendar calendar = Calendar.getInstance();
		long temp = calendar.getTimeInMillis() / (24 * 60 * 60 * 1000);
		logger.debug("距离开始计数天数：" + temp);
		if (temp > 0x7fff)
			return (short) (temp % 0x7fff);
		else
			return (short) temp;
	}

	/**
	 * 
	 * @Title: getMillisOfGMT
	 * @Description: 返回现在距离GMT(1970年1月1日00:00:00.000 GMT)时间的毫秒数
	 * @return 
	 * @return long
	 * @throws
	 */
	public static long getMillisOfGMT() {
		Calendar calendar = Calendar.getInstance();
		long temp = calendar.getTimeInMillis() ;
		logger.debug("距离开始计数毫秒数：" + temp);
		return temp;
	}
	
	/**
	 * 
	 * @Title: getMillisOfGMT
	 * @Description: 返回给定时间距离GMT(1970年1月1日00:00:00.000 GMT)时间的毫秒数
	 * @param calendar
	 * @return 
	 * @return long
	 * @throws
	 */
	public static long getMillisOfGMT(Calendar calendar) {
		//Calendar calendar = Calendar.getInstance();
		long temp = calendar.getTimeInMillis() ;
		logger.debug("距离开始计数毫秒数：" + temp);
		return temp;
	}
	
	/**
	 * 
	 * @Title: getMillisOfStart
	 * @Description: 返回现在时间距离START的毫秒数
	 * @param calendar
	 * @return 
	 * @return long
	 * @throws
	 */
	public static long getMillisOfStart() {
		Calendar calendar = Calendar.getInstance();
		long temp = calendar.getTimeInMillis()-START.getTimeInMillis();
		logger.debug("距离开始计数毫秒数：" + temp);
		return temp;
	}
	
	/**
	 * 
	 * @Title: getMillisOfStart
	 * @Description: 返回给定时间距离START的毫秒数
	 * @param calendar
	 * @return 
	 * @return long
	 * @throws
	 */
	public static long getMillisOfStart(Calendar calendar) {
		long temp = calendar.getTimeInMillis()-START.getTimeInMillis();
		logger.debug("距离开始计数毫秒数：" + temp);
		return temp;
	}

	/**
	 * 
	 * @Title: getMillisOfDay
	 * @Description: 获得现在距离今天凌晨00:00:00.000的毫秒数
	 * @return 
	 * @return int
	 * @throws
	 */
	public static int getMillisOfDay() {
		Calendar calendar = Calendar.getInstance();
		Calendar startOfDay = Calendar.getInstance();
		startOfDay.set(calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0,
				0, 0);
		long millis = calendar.getTimeInMillis() - startOfDay.getTimeInMillis();
		if (millis > 0x7fffffff)
			throw new RuntimeException("the getMsOfDay() millisecond too big.");
		else
			return (int) millis;
	}

	/**
	 * 
	 * @Title: getMillisOfDay
	 * @Description: 获得给定时间距离给定时间的凌晨00:00:00.000的毫秒数
	 * @param calendar
	 * @return 
	 * @return int
	 * @throws
	 */
	public static int getMillisOfDay(Calendar calendar) {
		// DateTimeFormatter formatter =
		// DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss SSS");
		// LocalDate
		// localDate=formatter.parseLocalDate("2015-09-17 00:00:00 000");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS")
					.parse("2000-01-01 00:00:00 000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar startOfDay = Calendar.getInstance();
		startOfDay.setTime(date);
		startOfDay.set(calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
		long millis = calendar.getTimeInMillis() - startOfDay.getTimeInMillis();
		if (millis > 0x7fffffff)
			throw new RuntimeException("the getMsOfDay() millisecond too big.");
		else
			return (int) millis;
	}
}
