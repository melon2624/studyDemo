package com.zx.lambda;

import java.util.function.Supplier;

/**
 * 求数组的最大值
 *
 * @author zhangxin
 * @date 2022/12/20 21:05
 */
public class SupplierLambda {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int max = getMax(() -> {
            int temp = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (temp < arr[i]) {
                    temp = arr[i];
                }
            }
            return temp;
        });
        System.out.println(max);

    }


    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

}
