package com.zx.coupon.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author zhangxin
 * @date 2022/11/8 17:04
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    @LoadBalanced
    public WebClient.Builder register() {
        return WebClient.builder();
    }

}
