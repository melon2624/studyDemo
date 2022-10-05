package com.zx.thread;

import java.util.concurrent.*;

/**
 * @author zhangxin
 * @date 2021/10/21 22:38
 */
public class HowToCreateThread {

    public static class Mythread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello Mythread");
        }
    }

    public static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static class Mycall implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "zhangxin Call";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Mythread().start();
        new Thread(new MyRun()).start();

        new Thread(() -> {
            System.out.println("Hello Lambda !");
        }).start();

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> future = service.submit(new Mycall());
        String S = future.get();

        System.out.println(S);
    }

}
