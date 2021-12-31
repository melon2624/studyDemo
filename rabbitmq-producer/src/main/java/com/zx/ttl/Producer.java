package com.zx.ttl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangxin
 * @date 2021-12-25 17:46
 */
public class Producer {


    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();


        Map<String, Object> arguments = new HashMap<>();
//            消息队列中消息过期时间，30s
        arguments.put("x-message-ttl", 10 * 1000);
//            如果消息队列没有消费者，则10s后消息过期，消息队列也删除
//            arguments.put("x-expires", 10 * 1000);
        arguments.put("x-expires", 100 * 1000);

        channel.queueDeclare("queue.ttl.waiting",
                true,
                false,
                false,
                arguments);

        channel.exchangeDeclare("ex.ttl.waiting",
                "direct",
                true,
                false,
                null);

        channel.queueBind("queue.ttl.waiting", "ex.ttl.waiting", "key.ttl.waiting");

        final AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .contentEncoding("utf-8")
                .deliveryMode(2)   // 持久化的消息
                .build();

        channel.basicPublish("ex.ttl.waiting",
                "key.ttl.waiting",
                null,
                "等待的订单号".getBytes("utf-8"));

        channel.close();
        connection.close();
    }

}
