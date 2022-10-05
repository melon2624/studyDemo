package com.zx.thread;

/**
 * @author zhangxin
 * @date 2021/10/26 0:04
 */
public class TestCountDownLatch {

    private static void usingCountDownLatch() throws InterruptedException {
      /*  Thread[] threads=new Thread[100];

        CountDownLatch latch=new CountDownLatch(threads.length);
*/
        Thread t = new Thread(() -> {
            System.out.println("start 111");
            SleepHelper.sleepSecond(1);
            System.out.println("end   ");
        });

        t.start();
        SleepHelper.sleepSecond(5);
        t.join();
        System.out.println(" zhangxin");


    }

    public static void main(String[] args) throws InterruptedException {
        usingCountDownLatch();
    }
}
