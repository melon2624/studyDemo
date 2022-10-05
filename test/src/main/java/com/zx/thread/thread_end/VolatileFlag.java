package com.zx.thread.thread_end;

import com.zx.thread.SleepHelper;

/**
 * @author zhangxin
 * @date 2021/10/23 14:21
 */
public class VolatileFlag {
    //volatile 有局限性
    private static volatile boolean running = true;

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            long i = 0L;
            while (running) {
                i++;
            }
            System.out.println("end and i= " + i);
        });
        t.start();

        SleepHelper.sleepSecond(1);
        running = false;

    }
}
