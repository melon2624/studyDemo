package com.zx;

import lombok.SneakyThrows;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @author zhangxin
 * @date 2022-01-03 1:32
 */
public class MyPushConsumer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        // 实例化推送消息消费者的对象，同时指定消费组名称
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group_02");
        // 指定nameserver的地址
        consumer.setNamesrvAddr("localhost:9876");

        // 订阅主题
        consumer.subscribe("tp_demo_02", "*");

        consumer.setMessageListener(new MessageListenerConcurrently() {
            @SneakyThrows
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                final MessageQueue messageQueue = consumeConcurrentlyContext.getMessageQueue();
                System.out.println(messageQueue);
                for (MessageExt messageExt : list) {

                    try {
                        System.out.println(new String(messageExt.getBody(), "utf-8"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //  初始化消费者，之后开始消费消息
        consumer.start();

        // 此处只是示例，生产中除非运维关掉，否则不应停掉，长服务
        Thread.sleep(30000);
        // 关闭消费者
        consumer.shutdown();

    }

}
