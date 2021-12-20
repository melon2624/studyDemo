package com.zx.spring.transfer.service;

import com.zx.entity.Account;
import com.zx.spring.transfer.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : zhangxin
 * @date : 2021-09-15 20:13
 **/
@Component
public class TransferServiceImpl implements TransferService {

    @Autowired
    AccountDao accountDao;


    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {

        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(money);
        to.setMoney(money);

        accountDao.updateAccountByCardNo(from);
        // int i=1/0;
        accountDao.updateAccountByCardNo(to);

    }
}
