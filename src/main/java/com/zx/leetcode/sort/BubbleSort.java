package com.zx.leetcode.sort;

/**
 * 冒泡排序
 *
 * @author : zhangxin
 * @date : 2021-08-19 17:26
 **/

public class BubbleSort {


    public static void main(String[] args) {

        int[] array = new int[]{3, 5, 1, -7, 4, 9, -6, 8, 10, 4};

        int size = array.length;

        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.printf(array.toString());


    }


}
