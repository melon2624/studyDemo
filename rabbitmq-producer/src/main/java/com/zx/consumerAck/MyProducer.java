package com.zx.consumerAck;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangxin
 * @date 2021-12-19 23:49
 */
public class MyProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("queue.ca", false, false, false, null);
        channel.exchangeDeclare("zx.ca", "direct", false, false, null);
        channel.queueBind("queue.ca", "zx.ca", "key.ca");

        for (int i = 0; i < 5; i++) {
            channel.basicPublish("zx.ca", "key.ca", null, ("hello-" + i).getBytes());
        }

        channel.close();
        connection.close();

    }
}
