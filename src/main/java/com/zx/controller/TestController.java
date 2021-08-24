package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zx.entity.User;
import com.zx.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	public String a="zx";

    @Autowired
    RedisUtils redisUtils;


    @RequestMapping("/zx/test")
    public  String test(){
        User user=new User();
        user.setId(1);
        user.setName("zhangxin");

        String userEntityJson = JSONObject.toJSONString(user);

        redisUtils.setString("zx",userEntityJson);

        return null;
    }
}
