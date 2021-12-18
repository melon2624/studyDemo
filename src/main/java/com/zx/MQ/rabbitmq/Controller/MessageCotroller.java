package com.zx.MQ.rabbitmq.Controller;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.io.UnsupportedEncodingException;

/**
 * @author zhangxin
 * @date 2021-12-18 23:39
 */
@RestController
public class MessageCotroller {


    //ctrl +f+B 查看这个接口使用情况
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/rabbit/{message}")
    public String receive(@PathVariable String message) throws UnsupportedEncodingException {

        final MessageProperties messageProperties = MessagePropertiesBuilder.newInstance().setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .setContentEncoding("utf-8")
                .setHeader("hello", "world")
                .build();

        final Message msg = MessageBuilder
                .withBody(message.getBytes("utf-8"))
                .andProperties(messageProperties)
                .build();

        rabbitTemplate.send("zx.boot", "key.boot", msg);

        return "ok";
    }

}
