package com.qingting.customer.model.common;

public class StringUtils {
	/**
	 * 验证可能为空格或者""及null的字符串
	 * 
	 * <pre>
	 *   StringUtils.isBlank(null)      = true
	 *   StringUtils.isBlank(&quot;&quot;)        = true
	 *   StringUtils.isBlank(&quot; &quot;)       = true
	 *   StringUtils.isBlank(&quot;bob&quot;)     = false
	 *   StringUtils.isBlank(&quot;  bob  &quot;) = false
	 * </pre>
	 * 
	 * @param cs
	 *            可能为空格或者""及null的字符序列
	 * @return
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(cs.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 验证可能为0或null的Byte数据
	 * 
	 * <pre>
	 *   StringUtils.isZeroOrNull(null)      = true
	 *   StringUtils.isZeroOrNull(0)        = true
	 *   StringUtils.isBlank(1)       = false
	 * </pre>
	 * 
	 * @param value
	 *            可能为0或者null的Integer数据
	 * @return
	 */
	public static boolean isZeroOrNull(Byte value){
		if(value==null)
			return true;
		if(value == 0)
			return true;
		return false;
	}
	/**
	 * 验证可能为0或null的Integer数据
	 * 
	 * <pre>
	 *   StringUtils.isZeroOrNull(null)      = true
	 *   StringUtils.isZeroOrNull(0)        = true
	 *   StringUtils.isBlank(1)       = false
	 * </pre>
	 * 
	 * @param value
	 *            可能为0或者null的Integer数据
	 * @return
	 */
	public static boolean isZeroOrNull(Integer value){
		if(value==null)
			return true;
		if(value == 0)
			return true;
		return false;
	}
	/**
	 * 验证可能为0或null的Long类型数据
	 * 
	 * <pre>
	 *   StringUtils.isZeroOrNull(null)      = true
	 *   StringUtils.isZeroOrNull(0)        = true
	 *   StringUtils.isBlank(1)       = false
	 * </pre>
	 * 
	 * @param value
	 *            可能为0或者null的Integer数据
	 * @return
	 */
	public static boolean isZeroOrNull(Long value){
		if(value==null)
			return true;
		if(value == 0)
			return true;
		return false;
	}
}
