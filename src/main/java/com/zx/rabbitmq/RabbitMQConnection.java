package com.zx.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : zhangxin
 * @date : 2021-08-10 19:22
 **/
public class RabbitMQConnection {

    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/consume_order_queue");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);

        return connectionFactory.newConnection();

    }
}
