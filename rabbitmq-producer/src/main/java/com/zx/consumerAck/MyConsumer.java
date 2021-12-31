package com.zx.consumerAck;

import com.rabbitmq.client.*;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangxin
 * @date 2021-12-19 23:41
 */
public class MyConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare("queue.ca", false, false, false, null);

        // 推消息模式
        // autoAck:false表示手动确认消息
        channel.basicConsume("queue.ca", false, "myConsumer", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println(new String(body));
                // 确认消息
//                channel.basicAck(envelope.getDeliveryTag(), false);

                // 第一个参数是消息的标签，第二个参数表示不确认多个消息还是一个消息
                // 第三个参数表示不确认的消息是否需要重新入列，然后重发
                // 可以用于拒收多条消息
//                channel.basicNack(envelope.getDeliveryTag(), false, true);
                // 用于拒收一条消息
                // 对于不确认的消息，是否重新入列，然后重发
                channel.basicReject(envelope.getDeliveryTag(), true);
               // channel.basicReject(envelope.getDeliveryTag(), false);
            }
        });
//        channel.close();
//        connection.close();

    }
}
