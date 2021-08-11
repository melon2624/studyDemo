package com.zx.rabbitmq.demo1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zx.rabbitmq.RabbitMQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : zhangxin
 * @date : 2021-08-10 19:29
 **/
public class Producer {

    private static  final  String QUEUE_NAME="zx_queue";

    public static void main(String[] args)  {

        try {
            //创建连接
            Connection connection= RabbitMQConnection.getConnection();
            //创建通道
            Channel channel=connection.createChannel();
            String msg="zhangxin111";
            channel.confirmSelect();
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            boolean result=channel.waitForConfirms();
            if (result) {
                System.out.println("消息投递成功");
            } else {
                System.out.println("消息投递失败");
            }
            channel.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
