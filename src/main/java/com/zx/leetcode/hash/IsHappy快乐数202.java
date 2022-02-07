package com.zx.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxin
 * @date 2022-01-31 18:49
 */
public class IsHappy快乐数202 {

    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int i = 0;
            while (n != 0) {
                int m = n % 10;
                i += m * m;
                n = n / 10;
            }
            if (set.contains(i)) {
                return false;
            } else {
                set.add(i);
                n = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean a = isHappy(2);

        System.out.println(a);
    }

}
