package com.zx.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;



/**
 * @auth xiaofeng
 * @date 2022/5/13
 * @time 17:04
 */
public class AESUtils {

    private static final String KEY = "9C345E37DF2240C084FCD8B4AF60E726";

    public static void main(String[] args) {
        System.out.println("------------生成秘钥--------------");
        generatorKey();

        System.out.println("------------加密-----------------");
        String text = "爱我中华";
        String encrypt = encrypt(KEY, text);
        System.out.println(encrypt);

        System.out.println("------------解密-----------------");
        String decrypt = decrypt(KEY, encrypt);
        System.out.println(decrypt);
    }

    /**
     * 生成秘钥
     */
    public static void generatorKey() {
        /*//128位秘钥
        String key1 = UUIDUtils.getId().replace("-", "").substring(0, 16);
        System.out.println(key1);
        //192位秘钥
        String key2 = UUIDUtils.getId().replace("-", "").substring(0, 24);
        System.out.println(key2);
        //256位秘钥
        String key3 = UUIDUtils.getId().replace("-", "");
        System.out.println(key3);*/
    }

    public static String encrypt(String key, String text) {
        //构建
        AES aes = SecureUtil.aes(key.getBytes());
        //加密
        return aes.encryptHex(text);
    }

    public static String decrypt(String key, String text) {
        //构建
        AES aes = SecureUtil.aes(key.getBytes());
        //加密
        return aes.decryptStr(text);
    }

}
