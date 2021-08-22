package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
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

        return null;
    }

    @RequestMapping("/zx/redis")
    public void  setString(){
        /*String key,String value*/
        User user=new User();
        user.setAge(24);
        user.setName("zhangxin");
        String json= JSONObject.toJSONString(user);

        redisUtils.setString("zx",json);

        System.out.printf(redisUtils.getString("zx"));

    }
}
