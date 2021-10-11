package com.zx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangxin
 * @date 2021/10/11 1:27
 */
@SpringBootApplication
@MapperScan("com.zx.mapper")
public class ShardingApp {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApp.class);
    }
}
