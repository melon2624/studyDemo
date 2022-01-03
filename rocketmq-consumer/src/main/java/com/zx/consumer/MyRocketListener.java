package com.zx.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangxin
 * @date 2022-01-03 12:57
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "tp_springboot_01",consumerGroup = "consumer_group_03")
public class MyRocketListener implements RocketMQListener<String> {


    @Override
    public void onMessage(String s) {
        log.info(s);

    }
}
