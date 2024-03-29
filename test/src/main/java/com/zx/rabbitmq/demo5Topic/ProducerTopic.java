package com.zx.rabbitmq.demo5Topic;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProducerTopic {

    /**
     * 定义交换机的名称
     */
    private static final String EXCHANGE_NAME = "topic_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        // 创建Channel
        Channel channel = connection.createChannel();
        // 通道关联交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "topic", true);
        String msg = "每特教育6666";
        channel.basicPublish(EXCHANGE_NAME, "mayikt.sms", null, msg.getBytes());
        channel.close();
        connection.close();
    }

}