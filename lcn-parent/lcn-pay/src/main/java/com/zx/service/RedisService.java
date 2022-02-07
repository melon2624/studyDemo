package com.zx.service;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.zx.entity.TblPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.channels.Selector;

/**
 * @author zhangxin
 * @date 2022-01-16 22:57
 */
@Service
public class RedisService {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @TccTransaction
    public String addPay(@RequestBody TblPay bean) {
        BoundValueOperations<String, String> pay = redisTemplate.boundValueOps("pay");
        pay.set("pay-value");
        //int i = 1 / 0;

        return "新增支付成功";
    }

    /**
     * 逆sql
     *
     * @param bean
     * @return
     */
    public String cancelAddPay(TblPay bean) {

        redisTemplate.delete("pay");
        System.out.println("pay cancel");
        return "取消支付成功";

    }


}
