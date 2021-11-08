package com.zx.leetcode.array;

/**
 * 162. 寻找峰值
 *
 * @author : zhangxin
 * @date : 2021-10-19 14:15
 **/

public class FindPeakElement {

    //第一遍暴力求解  leetcode提交答案错误
    public static int findPeakElement(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return 0;
        }

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (nums[i + 1] > nums[i]) {
                    return i;
                }
            } else if (i == length - 1) {
                if (nums[length - 1] > nums[length - 2]) {
                    return i;
                }
            } else {
                if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }

        return -1;
    }

    //第一遍 遍历数组，寻找数组的最大值，最大值一定是峰值 ，时间复杂度也是O(n)
    public static int findPeakElement2(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }


    //第一遍，二分法
    public static int findPeakElement3(int[] nums) {

        int left = 0, right = nums.length - 1;
        //int[] nums=new int[]{1,2,1,3,5,6,4};
        //                     0 1 2 3 4 5 6
        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right=mid;
            }
        }
        return left;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        //                   0 1 2 3 4 5 6

        int ans = findPeakElement2(nums);

        int ans3=findPeakElement3(nums);
    }

}
