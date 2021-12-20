package com.zx.MQ.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.MQ.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {

        //  创建Connection
        Connection connection = RabbitMQConnection.getConnection();
        final Channel channel = connection.createChannel();
        // 声明fanout类型的交换器
        channel.exchangeDeclare("zx.zhangxin", "fanout", true, false, null);

        for (int i = 0; i < 20; i++) {
            channel.basicPublish("zx.zhangxin",
                    "",  // fanout类型的交换器不需要指定路由键
                    null,
                    ("hello world zhangxin:" + i).getBytes("utf-8"));
        }

        channel.close();
        connection.close();

    }
}
