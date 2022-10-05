package com.zx.spring.transfer.service;

/**
 * @author : zhangxin
 * @date : 2021-09-15 20:12
 **/
public interface TransferService {

    void transfer(String fromCardNo, String toCardNo, int money) throws Exception;
}
