package com.zx.thread.thread_end;

import com.zx.thread.SleepHelper;

import java.util.concurrent.locks.LockSupport;

/**
 * @author zhangxin
 * @date 2021/10/23 14:50
 */
public class InterruptAndPark {

    public static void main(String[] args) {
        Thread t=new Thread(()->{
            System.out.println("1");
            LockSupport.park();
            System.out.println("2");

        });
        t.start();
        SleepHelper.sleepSecond(4);
        t.interrupt();
    }
}
