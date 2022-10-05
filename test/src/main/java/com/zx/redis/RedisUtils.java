package com.zx.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author : zhangxin
 * @date : 2021-08-23 10:49
 **/
@Component
public class RedisUtils {


    @Autowired
    private StringRedisTemplate redisTemplate;


    public void setString(String key, String value) {

        setString(key, value, null);
    }


    public void setString(String key, String value, Long timeout) {

        redisTemplate.opsForValue().set(key, value);
        if (timeout != null) {
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }

    }


}
