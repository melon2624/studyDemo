package com.zx.thread.thread_end;

import com.zx.thread.SleepHelper;

/**
 * Interrupt是设定标记位
 *
 * @author zhangxin
 * @date 2021/10/23 14:28
 */
public class Interrupt_NormalThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {

            while (!Thread.interrupted()) {

            }

            System.out.println("t end");
        });
        t.start();
        SleepHelper.sleepSecond(2);
        t.interrupt();
    }

}
