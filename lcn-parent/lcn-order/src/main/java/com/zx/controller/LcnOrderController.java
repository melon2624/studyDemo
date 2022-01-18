package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.zx.entity.TblOrder;
import com.zx.mapper.TblOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangxin
 * @date 2022-01-15 22:51
 */
@RestController
public class LcnOrderController {



    @Autowired
    private TblOrderMapper tblOrderMapper;

    @Autowired
    private RestTemplate restTemplate;



    @PostMapping("/zx/addorder")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String add(@RequestBody TblOrder bean) {

        JSONObject date = new JSONObject();
        date.put("payName", bean.getOrderName() + "pay");
        restTemplate.postForEntity("http://localhost:1002/add-pay", date, String.class);
       // int i = 1 / 0;
        tblOrderMapper.insert(bean);
        return "success";
    }

}
