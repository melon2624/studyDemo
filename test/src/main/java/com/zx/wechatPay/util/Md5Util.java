package com.zx.wechatPay.util;

import java.security.MessageDigest;

public class Md5Util {
	
	
	// 对数据进行md5加密,用于生成数字签名
	public static String md5Digest(String sourceStr) {
		return md5Digest(sourceStr,"UTF-8");
	}
	
	public static String md5Digest(String sourceStr, String chartSet) {
		if (sourceStr == null||sourceStr.trim().isEmpty()) {
			throw new NullPointerException("原字符串不能为NULL。");
		}
		if (chartSet == null||chartSet.trim().isEmpty()) {
			chartSet ="UTF-8";
		}
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] result = md5.digest(sourceStr.getBytes(chartSet));
			return bytesToHexString(result).toUpperCase();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 转成16进制
	public static String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2){
				sb.append(0);
			}
			sb.append(sTemp.toLowerCase());
		}
		return sb.toString();
	}
}
