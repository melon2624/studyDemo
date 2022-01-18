package com.zx.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.zx.entity.TblOrder;
import com.zx.mapper.TblOrderMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangxin
 * @date 2022-01-16 23:07
 */
@RestController
public class TccOrderRedisController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TblOrderMapper tblOrderMapper;


    @PostMapping("/add-order-tcc-redis")
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String add(@RequestBody TblOrder bean) {

        JSONObject date = new JSONObject();
        date.put("payName", bean.getOrderName() + "pay");
        restTemplate.postForEntity("http://localhost:1002/add-pay-tcc-redis", date, String.class);

        BoundValueOperations<String, String> order = redisTemplate.boundValueOps("order");
        order.set("order-value");
        TblOrder tblOrder = new TblOrder();
        tblOrder.setId(1);
        tblOrder.setOrderName("新");

        tblOrderMapper.insert(tblOrder);
        //   int i = 1 / 0;
        return "新增订单成功";

    }

}
