package com.zx.dlx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangxin
 * @date 2021-12-25 20:28
 */
public class Product {

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();

//            正常业务的交换器
        channel.exchangeDeclare("ex.biz", "direct", true);
        //            声明死信交换器 DLX
        channel.exchangeDeclare("ex.dlx", "direct", true);

//            声明队列做死信队列
        channel.queueDeclare("queue.dlx", true, false, false, null);
//            绑定死信交换器和死信队列
        channel.queueBind("queue.dlx", "ex.dlx", "key.dlx");


        Map<String, Object> arguments = new HashMap<>();
//            指定消息队列中的消息过期时间
        arguments.put("x-message-ttl", 10000);

//            指定过期消息通过死信交换器发送到死信队列，死信交换器的名称，DLX
        arguments.put("x-dead-letter-exchange", "ex.dlx");
//            指定死信交换器的路由键
        arguments.put("x-dead-letter-routing-key", "key.dlx");

        channel.queueDeclare("queue.biz", true, false, false, arguments);
        //            绑定业务的交换器和消息队列
        channel.queueBind("queue.biz", "ex.biz", "key.biz");

        channel.basicPublish("ex.biz", "key.biz", null, "orderid.45789987678".getBytes());
        channel.close();
        connection.close();

    }

}
