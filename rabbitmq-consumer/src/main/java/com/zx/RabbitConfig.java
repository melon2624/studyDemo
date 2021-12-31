package com.zx;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxin
 * @date 2021-12-18 23:17
 */
@Configuration
public class RabbitConfig {


    @Bean
    public Queue queue() {
        return QueueBuilder.nonDurable("queue.boot").build();
    }


}
