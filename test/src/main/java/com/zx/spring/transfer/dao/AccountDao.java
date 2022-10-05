package com.zx.spring.transfer.dao;

import com.zx.entity.Account;

/**
 * @author : zhangxin
 * @date : 2021-09-15 20:15
 **/
public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;

}
