package com.zx.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.zx.entity.TblPay;
import com.zx.mapper.TblPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxin
 * @date 2022-01-15 21:14
 */

@RestController
public class LcnPayController {


    @Autowired
    private TblPayMapper tblPayDao;

    @PostMapping("/add-pay")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String addPay(@RequestBody TblPay bean){
        tblPayDao.insert(bean);
        return "新增支付成功";

    }

}
