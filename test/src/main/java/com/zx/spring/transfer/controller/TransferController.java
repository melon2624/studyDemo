package com.zx.spring.transfer.controller;

import com.zx.spring.transfer.ProxyFactory;
import com.zx.spring.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhangxin
 * @date : 2021-09-15 20:34
 **/
@RestController
@RequestMapping("/zx")
public class TransferController {

    @Autowired
    ProxyFactory proxyFactory;

    @Autowired
    TransferService transferService;


    TransferService transferServiceProxy;

    @PostMapping("/transfer")
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        transferServiceProxy = (TransferService) proxyFactory.getJdkProxy(transferService);
        transferServiceProxy.transfer(fromCardNo, toCardNo, money);

    }

}
