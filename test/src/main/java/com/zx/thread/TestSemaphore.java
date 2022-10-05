package com.zx.thread;

import java.util.concurrent.Semaphore;

/**
 * @author zhangxin
 * @date 2021/10/27 0:27
 */
public class TestSemaphore {

    public static Semaphore semaphore = new Semaphore(1);

    public static void read(Semaphore semaphore) throws InterruptedException {
        semaphore.acquire();
        System.out.println("read 1111");
        Thread.sleep(200);
        System.out.println("read 2222");
        semaphore.release();
    }

    public static void write(Semaphore semaphore) throws InterruptedException {
        semaphore.acquire();
        System.out.println("write 11111");
        Thread.sleep(200);
        System.out.println("write 222222");
        semaphore.release();
    }

    public static void main(String[] args) {

        Runnable r = () -> {
            try {
                read(semaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable w = () -> {
            try {
                write(semaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r).start();
        new Thread(w).start();

    }
}
