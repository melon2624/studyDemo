package com.zx.thread.Volatile;

import com.zx.thread.SleepHelper;

/**
 * @author zhangxin
 * @date 2021/10/23 15:12
 */
public class HelloVolatile {

    public static volatile boolean running = true;

    public static void main(String[] args) {
        System.out.println("m start");
        Thread t = new Thread(() -> {
            while (running) {

            }
            System.out.println("end");
        });
        t.start();

        SleepHelper.sleepSecond(2);
        running = false;
    }
}
