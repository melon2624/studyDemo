package com.zx.persistent;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangxin
 * @date 2021-12-19 23:19
 */
public class PersistentProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("queue.persistent", true, false, false, null);
        // durable:true表示是持久化消息队列
        channel.exchangeDeclare("zx.persistent", "direct", true, false, null);
        // 持久化的交换器
        channel.queueBind("queue.persistent", "zx.persistent", "key.persistent");

        final AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .deliveryMode(2) // 表示是持久化消息
                .build();

        channel.basicPublish("zx.persistent",
                "key.persistent",
                properties,  // 设置消息的属性，此时消息是持久化消息
                "hello world".getBytes());
        channel.close();
        connection.close();

    }
}
