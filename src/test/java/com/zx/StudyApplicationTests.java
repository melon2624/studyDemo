package com.zx;

import com.alibaba.fastjson.JSONObject;
import com.zx.entity.User;
import com.zx.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyApplicationTests {

    @Autowired
    RedisUtils redisUtils;

    @Test
    void contextLoads() {
    }


    @Test
    void RedisTest() {
        User user = new User();
        user.setId(1);
        user.setName("zhangxin");

        String userEntityJson = JSONObject.toJSONString(user);

        redisUtils.setString("zx", userEntityJson);
    }





}
