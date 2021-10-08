package com.zx.spring.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zhangxin
 * @date : 2021-09-17 18:18
 **/

@Service
@Transactional
public class TransactionService {


        public void test(){
            System.out.println("transaction");
        }

}
