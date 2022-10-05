package com.zx.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangxin
 * @date 2021/10/27 0:00
 */
public class TestReadWriteLock {

    static Lock lock = new ReentrantLock();

    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = readWriteLock.readLock();

    static Lock writeLock = readWriteLock.writeLock();


    public static void read(Lock lock) {
        lock.lock();
        try {
            SleepHelper.sleepSecond(2);
            System.out.println("read over");
            //模拟读操作
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int value) {

        lock.lock();
        try {
            SleepHelper.sleepSecond(2);
            System.out.println(" wirte over");
            //模拟写操作;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Runnable readRunnbale = () -> read(lock);
        Runnable writeRunnble = () -> write(lock, 5);

        for (int i = 0; i < 12; i++) {
            new Thread(readRunnbale).start();
        }

        for (int j = 0; j < 3; j++) {
            new Thread(writeRunnble).start();
        }

    }


}
