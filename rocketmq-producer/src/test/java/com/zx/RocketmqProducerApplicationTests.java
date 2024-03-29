package com.zx;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketmqProducerApplicationTests {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void contextLoads() {
        // 用于向broker发送消息
        // 第一个参数是topic名称
        // 第二个参数是消息内容
        this.rocketMQTemplate.convertAndSend(
                "tp_springboot_01",
                "tencent01");
    }

    @Test
    public  void  testSendMessages(){
            for (int i=0;i<100;i++){
                // 用于向broker发送消息
                // 第一个参数是topic名称
                // 第二个参数是消息内容
                this.rocketMQTemplate.convertAndSend(
                        "tp_springboot_01",
                        "tencent"+i);
            }
    }

}
