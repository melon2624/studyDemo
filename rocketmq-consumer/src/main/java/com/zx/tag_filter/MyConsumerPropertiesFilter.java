package com.zx.tag_filter;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @author zhangxin
 * @date 2022-01-03 15:49
 */
public class MyConsumerPropertiesFilter {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_grp_06_02");

        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("tp_demo_06", MessageSelector.bySql("mykey in('v0','v1')"));

        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                final MessageQueue messageQueue = consumeConcurrentlyContext.getMessageQueue();
                final String brokerName = messageQueue.getBrokerName();
                final String topic = messageQueue.getTopic();
                final int queueId = messageQueue.getQueueId();
                System.out.println(brokerName + "\t" + topic + "\t" + queueId);
                for (MessageExt messageExt : list) {
                    System.out.println(messageExt);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //初始化并启动消费者
        consumer.start();

    }

}
