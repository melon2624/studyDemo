package com.zx.coupon.calculation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangxin
 * @date 2022/10/25 10:29
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CalculationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculationApplication.class, args);
    }
}
