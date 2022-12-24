package com.zx.jwt;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author zhangxin
 * @date 2022/12/19 13:39
 */
public class JWTDemo3 {



    public static void main(String[] args) throws UnsupportedEncodingException {
        String jwtSecret = "zhangxinkey";

        // jwt jwtHeader
        JSONObject jwtHeader = new JSONObject();

        jwtHeader.put("alg","HS256");
        jwtHeader.put("typ","jwt");

        // jwt playload
        JSONObject jwtPlayload = new JSONObject();
        jwtPlayload.put("userName","zhangxin430426");
        jwtPlayload.put("age",25);

        //base64JwtHeader
        String base64JwtHeader= Base64.getEncoder().encodeToString(jwtHeader.toJSONString().getBytes());
        String base64JwtPlayload= Base64.getEncoder().encodeToString(jwtPlayload.toJSONString().getBytes());

        // 使用MD5 生成签名
        String signature= DigestUtils.md5Hex(jwtPlayload.toJSONString()+jwtSecret);

        String jwt=base64JwtHeader+"."+base64JwtPlayload+"."+signature;

        System.out.println(jwt);

        // 解密
        String jwtPlayloadStr=new String(Base64.getDecoder().decode(jwt.split("\\.")[1].getBytes()),
                "UTF-8");
        String jwtsignatureStr=jwt.split("\\.")[2];
        System.out.println(DigestUtils.md5Hex(jwtPlayloadStr+jwtSecret).equals(jwtsignatureStr));



    }



}
