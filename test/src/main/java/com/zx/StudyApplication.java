package com.zx;

import com.zx.spring.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class StudyApplication {


    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(StudyApplication.class, args);
     //   TransactionService transactionService = (TransactionService) applicationContext.getBean("transactionService");
    }

}
