package com.zx.loadbalance;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author zhangxin
 * @date 2022-01-03 23:36
 */
public class MyConsumer {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("consumer_pull_grp_01");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.start();
        final PullResult result = consumer.pull(new MessageQueue("tp_demo_06", "DESKTOP-HUGJMIH", 1),
                "*", 0, 10);
        System.out.println(result);
        System.out.println(result.getMsgFoundList().get(0));
        result.getMsgFoundList().forEach(messageExt -> {
            System.out.println(messageExt);
        });

        consumer.shutdown();
    }
}
