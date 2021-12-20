package com.zx.MQ.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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

        return new Queue("queue.boot",
                false,
                false,
                false,
                null);
    }

    @Bean
    public Exchange exchange() {

        return new TopicExchange("zx.boot",
                false,
                false,
                null);
    }

    public Binding binding() {

        return new Binding("queue.boot",
                Binding.DestinationType.QUEUE,
                "zx.boot",
                "key.boot",
                null);
    }

}
