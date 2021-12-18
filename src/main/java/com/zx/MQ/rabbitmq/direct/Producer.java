package com.zx.MQ.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class Producer {

    private final static String[] LOG_LEVEL = {
            "ERROR",
            "FATAL",
            "WARN"
    };

    private static Random random = new Random();

    public static void main(String[] args) throws IOException, TimeoutException {

        //   String level=LOG_LEVEL[random.nextInt(100)%LOG_LEVEL.length];

        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();
        // 声明fanout类型的交换器
        channel.exchangeDeclare("zx.direct", "direct", true, false, null);

        for (int i = 0; i < 100; i++) {
            String level = LOG_LEVEL[random.nextInt(100) % LOG_LEVEL.length];
            channel.basicPublish("zx.direct", level, null, ("这是【" + level + "】的消息" + i).getBytes());
        }
    }

}


