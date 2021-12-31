package com.zx.consumerQoS;

import com.rabbitmq.client.*;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangxin
 * @date 2021-12-20 23:18
 */
public class MyConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare("queue.qos", false, false, false, null);

        channel.queueDeclare("queue.qos", false, false, false, null);

        // 使用basic做限流，仅对消息推送模式生效。
        // 表示Qos是10个消息，最多有10个消息等待确认
        channel.basicQos(10);
        // 表示最多10个消息等待确认。如果global设置为true，则表示只要是使用当前的channel的Consumer，该设置都生效
        // false表示仅限于当前Consumer
        channel.basicQos(10, false);
        // 第一个参数表示未确认消息的大小，Rabbit没有实现，不用管。
        channel.basicQos(1000, 10, true);

        channel.basicConsume("queue.qos", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // some code going on
                // 可以批量确认消息，减少每个消息都发送确认带来的网络流量负载。
                channel.basicAck(envelope.getDeliveryTag(), true);
            }
        });

        channel.close();
        connection.close();

    }
}
