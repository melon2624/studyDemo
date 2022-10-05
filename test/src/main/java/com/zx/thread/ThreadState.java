package com.zx.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangxin
 * @date 2021/10/22 0:40
 */
public class ThreadState {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            System.out.printf("2:" + Thread.currentThread().getState());
            for (int i = 0; i < 3; i++) {
                SleepHelper.sleepSecond(1);
                System.out.printf(i + " ");
            }
            System.out.println();
        });
        System.out.println("1: " + t1.getState());
        t1.start();
        t1.join();
        System.out.println("3: " + t1.getState());
//===============================================
        Thread t2 = new Thread(() -> {

            try {
                LockSupport.park();
                System.out.println("t2 go on");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("4:" + t2.getState());

        LockSupport.unpark(t2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("5:" + t2.getState());

        //===================
        final Object object = new Object();
        Thread t3 = new Thread(() -> {
            synchronized (object) {
                System.out.println("t3 得到了锁 object");
            }
        });

        new Thread(() -> {
            synchronized (object) {
                SleepHelper.sleepSecond(5);
            }
        }).start();

        SleepHelper.sleepSecond(1);
        t3.start();
        SleepHelper.sleepSecond(1);
        System.out.println("6 " + t3.getState());
//===================================================
        final Lock lock = new ReentrantLock();

        Thread t4 = new Thread(() -> {
            lock.lock();
            System.out.println("t4 得到了锁");
        });

        new Thread(() -> {
            lock.lock();
            SleepHelper.sleepSecond(5);
            lock.unlock();
        }).start();
        SleepHelper.sleepSecond(1);
        t4.start();
        SleepHelper.sleepSecond(1);
        System.out.println("7 " + t4.getState());

    }
}
