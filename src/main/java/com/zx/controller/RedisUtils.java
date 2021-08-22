package com.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangxin
 * @date 2021/8/21 21:47
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;


    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setString(String key, String value, Long timeOut) {

        redisTemplate.opsForValue().set(key, value);

        if (timeOut != null) {
            redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        }

    }

    public String getString(String key) {

        return redisTemplate.opsForValue().get(key);

    }

}
