package com.zx.java8;

import java.time.Duration;
import java.time.Instant;

/**
 * @author： zhangxin
 * @date： 2021-06-27 00:07
 */
public class Test05 {
    public static void main(String[] args) {
        Instant start = Instant.now();
        long sum = 0;
        System.out.println("zhangxin");
        System.out.println("zhangxinnnnnn");
        for (long i = 0; i < 50000000000L; i++) {
            sum += i;
        }
        Instant end = Instant.now();
        System.out.println("五百亿求和所花费时间" + Duration.between(start, end).toMillis());
    }
}
