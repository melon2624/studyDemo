package com.zx.controller;

import cn.hutool.core.util.StrUtil;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * @author:LQL
 * @date:2020年3月14日
 * @description:字符串处理工具
 */
public class StringUtil {

	/**
	 * 
	 * @author:LQL
	 * @date:2019年10月30日
	 * @return: boolean
	 * @param str
	 * @description:判断字符串是空、空白、null
	 */
	public static boolean isEmpty(Object str) {
		return (str == null || valueOf(str).trim().length() == 0);
	}

	public static boolean isNull(Object str) {
		return "null".equals(str);

	}

	/**
	 * 
	 * @author:LQL
	 * @date:2019年10月30日
	 * @return: boolean
	 * @param str
	 * @return: boolean
	 * @description:判断字符串非空、非空白、非null
	 */
	public static boolean isNotEmpty(Object str) {
		return !isEmpty(str);
	}

	/**
	 * 
	 * @author:LQL
	 * @date:2019年10月30日
	 * @return: boolean
	 * @param str
	 * @return: String
	 * @description:去掉空白字符
	 */
	public static String trim(Object str) {
		return str == null ? null : valueOf(str).trim();
	}

	/**
	 * 
	 * @author:LQL
	 * @date:2019年10月30日
	 * @return: String
	 * @param str
	 * @return: String
	 * @description:对象转字符串
	 */
	public static String valueOf(Object str) {
		if (str == null) {
			return "";
		} else {
			return String.valueOf(str);
		}

	}

	/**
	 * 拼接字符串
	 *
	 * @param objects source
	 * @return result
	 */
	public static String concat(Object... objects) {
		if (objects == null || objects.length == 0) {
			return null;
		}
		StringBuilder result = new StringBuilder(8);
		for (Object object : objects) {
			result.append(object);
		}
		return result.toString();
	}

	public static String getStringFirstLower(String str) {
		if (StrUtil.isNotBlank(str)) {
			return str.substring(0, 1) + str.substring(1, 2).toLowerCase() + str.substring(2);
		}
		return str;
	}

	/**
	 * 去掉字符串里面所有的空格，包括字符串中间的空格
	 *
	 * @return
	 */
	public static String trimAllBlank(String str) {
		if (str == null) {
			return null;
		}
		return str.replaceAll("\\s", "");
	}

	/**
	 * 只检查11位和以1开头，因为有很多虚拟的号段，不好检查。
	 *
	 * @param mobile 手机号
	 * @return 是否合法
	 */
	public static boolean isMobileNO(String mobile) {
		if (StrUtil.isEmpty(mobile) || mobile.length() != 11) {
			return false;
		}

		return mobile.startsWith("1");
	}

	public static void main(String agrs[]) {

		System.out.println(isEmpty("  "));

	}

	/**
	 * LQL 2021年11月23日
	 * 
	 * @Title: split
	 * @Description: TODO
	 * @param
	 * @return
	 * @return String []
	 * @throws
	 */

	public static String[] split(String toSplit, String delimiter) {
		if (isEmpty(toSplit) || isEmpty(delimiter)) {
			return null;
		}
		int offset = toSplit.indexOf(delimiter);
		if (offset < 0) {
			return null;
		}

		String beforeDelimiter = toSplit.substring(0, offset);
		String afterDelimiter = toSplit.substring(offset + delimiter.length());
		return new String[] { beforeDelimiter, afterDelimiter };
	}

	/**
	 * 对比两个字符串是否相等
	 * @param cs1
	 * @param cs2
	 * @return
	 */
	public static boolean equals(CharSequence cs1, CharSequence cs2) {
		if (cs1 == cs2) {
			return true;
		} else if (cs1 != null && cs2 != null) {
			if (cs1.length() != cs2.length()) {
				return false;
			} else if (cs1 instanceof String && cs2 instanceof String) {
				return cs1.equals(cs2);
			} else {
				int length = cs1.length();

				for(int i = 0; i < length; ++i) {
					if (cs1.charAt(i) != cs2.charAt(i)) {
						return false;
					}
				}

				return true;
			}
		} else {
			return false;
		}
	}

	private static String changeFirstCharacterCase(String str, boolean capitalize) {
		if (isEmpty(str)) {
			return str;
		}

		char baseChar = str.charAt(0);
		char updatedChar;
		if (capitalize) {
			updatedChar = Character.toUpperCase(baseChar);
		} else {
			updatedChar = Character.toLowerCase(baseChar);
		}
		if (baseChar == updatedChar) {
			return str;
		}

		char[] chars = str.toCharArray();
		chars[0] = updatedChar;
		return new String(chars);
	}

	/**
	 * LQL 2021年11月23日
	 * 
	 * @Title: capitalize
	 * @Description: TODO
	 * @param name
	 * @return
	 * @return String
	 * @throws
	 */

	public static String capitalize(String name) {
		// TODO Auto-generated method stub
		return changeFirstCharacterCase(name, true);
	}

	/**
	 * 把collection变成指定字符串
	 *
	 * @param collection 1 2 3
	 * @return 1,2,3
	 */
	public static String getCollectionToStr(Collection<?> collection) {
		if(collection == null ){
			return null;
		}
		Iterator<?> it = collection.iterator();
		if (! it.hasNext()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (;;) {
			Object e = it.next();
			sb.append(e == collection ? "(this Collection)" : e);
			if (! it.hasNext()) {
				return sb.toString();
			}
			sb.append(',');
		}
	}
}
