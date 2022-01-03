package com.zx.tag_filter;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import javax.management.StringValueExp;

/**
 * @author zhangxin
 * @date 2022-01-03 15:21
 */
public class MyProducer6propertitesFilter {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {

        DefaultMQProducer producer = new DefaultMQProducer("producer_group_06");

        producer.setNamesrvAddr("localhost:9876");

        producer.start();

        Message message = null;

        for (int i = 0; i < 100; i++) {
            message = new Message("tp_demo_06", ("2022zhangxin" + i).getBytes());
            String value = null;
            switch (i % 3) {
                case 0:
                    value = "v0";
                    break;
                case 1:
                    value = "v1";
                    break;
                case 2:
                    value = "v2";
                    break;
            }
            //给消息添加用户属性
            message.putUserProperty("mykey", value);
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult.getSendStatus());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        Thread.sleep(3000);
        producer.shutdown();
        
    }
}
