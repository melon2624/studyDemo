package com.zx.rabbitmq;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author : zhangxin
 * @date : 2021-08-05 15:30
 **/
public class ThreadMQ {

    private static LinkedBlockingDeque<JSONObject> msgs = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        JSONObject data = new JSONObject();
                        data.put("name", "zhangxin");
                        System.out.println(Thread.currentThread().getName() + "," + data);
                        msgs.offer(data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "生产者");

        producer.start();

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    while (true) {
                        JSONObject jsonObject = msgs.poll();
                        if (jsonObject != null) {

                            System.out.println(Thread.currentThread().getName() + "," + jsonObject);
                        }
                    }
                } catch (Exception e) {

                }
            }
        }, "消费者");

        consumer.start();

    }

}
