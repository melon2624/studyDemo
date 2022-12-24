package com.zx.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author zhangxin
 * @date 2022/12/19 11:29
 */
public class JWTDemo1 {

    public static void main(String[] args) {
        //jwt密钥
        String signKey = "zhangxinKey";
        // 创建jwt
        JwtBuilder jwtBuilder = Jwts.builder().setId("666").setSubject("zhangxin").setIssuedAt(new Date())
                .claim("username","zhangxin")
        //签名值
                .signWith(SignatureAlgorithm.HS256,signKey);
        System.out.println(jwtBuilder.compact());
    }

}
