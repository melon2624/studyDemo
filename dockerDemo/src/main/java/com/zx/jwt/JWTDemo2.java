package com.zx.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author zhangxin
 * @date 2022/12/19 13:35
 */
public class JWTDemo2 {

    public static void main(String[] args) {

        //jwt密钥
        String signKey = "zhangxinKey";

        String jwt="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiJ6aGFuZ3hpbiIsImlhdCI6MTY3MTQyODA2MywidXNlcm5hbWUiOiJ6aGFuZ3hpbiJ9.h9mguZ2D0Yb4ljueOIkjrMXY1KsQaELgXDIxjzYTbBc";

        Claims body= Jwts.parser().setSigningKey(signKey).parseClaimsJws(jwt).getBody();

        System.out.println(body.get("username"));


    }

}
