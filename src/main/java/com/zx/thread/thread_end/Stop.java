package com.zx.thread.thread_end;

import com.zx.thread.SleepHelper;

/**
 * @author zhangxin
 * @date 2021/10/23 13:33
 */
public class Stop {
    //为什么不建议用stop 直接释放锁
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("go on");
                SleepHelper.sleepSecond(1);
            }
        });
        t1.start();

        SleepHelper.sleepSecond(5);
        t1.stop();
    }

}
