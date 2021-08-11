package com.zx.rabbitmq.demo4Direct;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerDirect {

    /**
     * 定义交换机的名称
     */
    private static final String EXCHANGE_NAME = "direct_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        // 创建Channel
        Channel channel = connection.createChannel();
        // 通道关联交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
        String msg = "zhangxin6666";
        channel.basicPublish(EXCHANGE_NAME, "email", null, msg.getBytes());
        channel.close();
        connection.close();
    }

}