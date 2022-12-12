package com.zx.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Md5EncryptionUtils {
	
	/**
	 * 
	 * @author:LQL
	 * @date:2019年10月30日
	 * @return: String
	 * @param pMap
	 * @return: String
	 * @description:对集键、值去空白按键ASCII升序排序后MD5加密-字母转换为大写
	 */
	public static String getMd5(Map<String, String> pMap) {
		Map<String, String> sortedParams = new TreeMap<String, String>(pMap);
		Set<Entry<String, String>> entrys = sortedParams.entrySet();
		StringBuilder basestring = new StringBuilder();
		for (Entry<String, String> param : entrys) {
			basestring.append(StringUtil.trim(param.getKey()) ).append("=").append(StringUtil.trim(param.getValue()));
		}
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(basestring.toString().getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}
		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		String s = hex.toString().toUpperCase();
		return s;
	}
	/**
	 * 
	 * @author:LQL
	 * @date:2019年10月30日
	 * @return: String
	 * @param str
	 * @return: String
	 * @description:字符串md5加密-字母转换为大写
	 */
	public static String getMd5(String str) {
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(StringUtil.trim(str).getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}
		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		String s = hex.toString().toUpperCase();
		return s;
	}
	
	public static void main(String agrs[]) {
		System.out.println(Md5EncryptionUtils.getMd5(""));
	}



}
