package com.zx.leetcode.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 *
 * @author : zhangxin
 * @date : 2021-10-08 18:29
 **/
public class SearchRange {

    //还没做完

    public static int[] searchRange(int[] array, int target) {
        int[] num = new int[2];
        int left = 0, right = array.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] > target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }

        if (left == array.length) {//数组不存在target
            num[0] = -1;
        }
        if (array[left] == target) {
            num[0] = left;
        } else {
            num[0] = -1;
        }

        left = 0;
        right = array.length;
        while (left < right) {
            int mid = left + right;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] > target) {

            }
        }

        return num;

    }

}
