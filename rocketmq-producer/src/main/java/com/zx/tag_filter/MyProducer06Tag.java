package com.zx.tag_filter;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author zhangxin
 * @date 2022-01-03 15:13
 */
public class MyProducer06Tag {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {

        DefaultMQProducer producer = new DefaultMQProducer("producer_group_06");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        Message message = null;
        for (int i = 0; i < 100; i++) {
            message = new Message("tp_demo_06", "tag-" + (i % 3), ("zhangxin" + i).getBytes());
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult.getSendStatus());
                }

                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(3000);
        producer.shutdown();

    }


}
