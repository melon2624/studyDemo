package com.zx.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangxin
 * @date 2021/10/22 0:44
 */
public class SleepHelper {

    public static void sleepSecond(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
