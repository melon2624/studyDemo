package com.zx.MQ.rabbitmq.fanout;

import com.rabbitmq.client.*;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class OneConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建我们的连接
        Connection connection = RabbitMQConnection.getConnection();
        // 创建我们通道
        final Channel channel = connection.createChannel();
        //声明临时队列，队列的名字由RabbitMQ自动生成
        String queueName = channel.queueDeclare().getQueue();

        System.out.printf("生成的临时队列的名字为:" + queueName);

        channel.exchangeDeclare("zx.zhangxin", BuiltinExchangeType.FANOUT, true, false, null);

        channel.queueBind(queueName, "zx.zhangxin", "");
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("One" + msg);
            }
        };

        channel.basicConsume(queueName, consumer);


    }
}
