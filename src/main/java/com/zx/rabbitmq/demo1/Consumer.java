package com.zx.rabbitmq.demo1;

import com.rabbitmq.client.*;
import com.zx.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : zhangxin
 * @date : 2021-08-10 19:53
 **/
public class Consumer {

    private static  final  String QUEUE_NAME="zx_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接
        Connection connection = RabbitMQConnection.getConnection();
        // 2.设置通道
        Channel channel = connection.createChannel();

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("消费者获取消息:" + msg);
//                // 消费者完成 消费者通知给mq服务器端删除该消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 3.监听队列
        channel.basicConsume(QUEUE_NAME, false, defaultConsumer);

    }
}
