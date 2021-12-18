package com.zx.MQ.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class Producer {

    private static final String[] LOG_LEVEL = {"info", "error", "warn"};
    private static final String[] LOG_AREA = {"beijing", "shanghai", "shenzhen"};
    private static final String[] LOG_BIZ = {"edu-online", "biz-online", "emp-online"};

    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();
        // 声明fanout类型的交换器
        channel.exchangeDeclare("zx.topic", "topic", true, false, null);
        String area, level, biz;
        String routingKey, message;
        for (int i = 0; i < 200; i++) {
            area = LOG_AREA[RANDOM.nextInt(LOG_AREA.length)];
            level = LOG_LEVEL[RANDOM.nextInt(LOG_LEVEL.length)];
            biz = LOG_BIZ[RANDOM.nextInt(LOG_BIZ.length)];
            // routingKey中包含了三个维度
            routingKey = area + "." + biz + "." + level;
            message = "LOG: [" + level + "] :这是 [" + area + "] 地区 [" + biz + "] 服务器发来的消息，MSG_SEQ = " + i;
            channel.basicPublish("zx.topic", routingKey, null, message.getBytes("utf-8"));
        }
    }
}
