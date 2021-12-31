package com.zx;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * @author zhangxin
 * @date 2021-12-19 0:08
 */
@Component
public class MyMessageListener {

  /*  @RabbitListener(queues = "queue.boot")
    public void getMyMessage(@Payload String message, @Header(name = "hello") String value, Channel channel) {
        System.out.println(message);
        System.out.println("hello = " + value);

//        // 确认消息
//        channel.basicAck();
//        // 拒收消息
//        channel.basicReject();
    }*/
}
