package com.zx.controller;

import com.zx.entity.TblPay;
import com.zx.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxin
 * @date 2022-01-16 23:03
 */
@RestController
public class TccpayRedisController {


    @Autowired
    private RedisService redisService;


    @PostMapping("/add-pay-tcc-redis")
    @Transactional(rollbackFor = Exception.class)
    public String addPay(@RequestBody TblPay bean) {
        redisService.addPay(null);
        //int i = 1 / 0;
        return "新增支付成功";
    }
}
