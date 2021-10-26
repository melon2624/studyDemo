package com.zx.thread.thread_end;

import com.zx.thread.SleepHelper;

/**
 * @author zhangxin
 * @date 2021/10/23 13:38
 */
public class Suspend_Resume {

    public static void main(String[] args) {

        Thread t=new Thread(()->{
            while (true){
                System.out.println("go on");
                SleepHelper.sleepSecond(1);
            }
        });

        t.start();

        SleepHelper.sleepSecond(5);
        t.suspend();
        SleepHelper.sleepSecond(3);
        t.resume();
    }
}
