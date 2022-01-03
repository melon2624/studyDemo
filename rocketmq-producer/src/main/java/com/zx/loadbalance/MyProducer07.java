package com.zx.loadbalance;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author zhangxin
 * @date 2022-01-03 22:28
 */
public class MyProducer07 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer("producer_grp_02");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        Message message = new Message();
        message.setTopic("tp_demo_06");
        message.setBody("xkdtm".getBytes());

        final SendResult result = producer.send(message, new MessageQueue("tp_demo_06", "DESKTOP-HUGJMIH", 3)
                , 1000);
        System.out.println(result.getSendStatus());
        producer.shutdown();


    }
}
