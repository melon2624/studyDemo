package com.zx.MQ.rabbitmq.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class WarnConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建我们的连接
        Connection connection = RabbitMQConnection.getConnection();
        // 创建我们通道
        final Channel channel = connection.createChannel();
        channel.exchangeDeclare("zx.direct", BuiltinExchangeType.DIRECT, true, false, null);
        // 此处也可以声明为临时消息队列
        channel.queueDeclare("queue.warn", false, false, false, null);

        channel.queueBind("queue.warn", "zx.direct", "WARN");
        channel.basicConsume("queue.warn", ((consumerTag, message) -> {
            System.out.println("warnConsumer收到的消息：" + new String(message.getBody(), "utf-8"));
        }), consumerTag -> {
        });

    }
}
