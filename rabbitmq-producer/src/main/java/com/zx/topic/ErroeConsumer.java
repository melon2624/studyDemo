package com.zx.MQ.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ErroeConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建我们的连接
        Connection connection = RabbitMQConnection.getConnection();
        // 创建我们通道
        final Channel channel = connection.createChannel();
        // 临时队列，返回值是服务器为该队列生成的名称
        final String queue = channel.queueDeclare().getQueue();
        channel.exchangeDeclare("zx.topic", "topic", true, false, null);
        //beijing.biz-online.error
        //只要routingKey是以beijing开头的，后面不管几个点分单词，都可以接收
        channel.queueBind(queue, "zx.topic", "beijing.#");

        channel.basicConsume(queue, (consumerTag, message) -> {
            System.out.println(new String(message.getBody(), "utf-8"));
        }, consumerTag -> {
        });

    }
}
