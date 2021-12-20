package com.zx.leetcode.array;

/**
 * 209. 长度最小的子数组  中等
 *
 * @author : zhangxin
 * @date : 2021-10-13 18:05
 **/
public class MinSubArrayLen {


    public static int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE;

        int sum = 0;

        int subLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = result < subLength ? result : subLength;

                    break;

                }

            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;

    }

    //第二遍自己写
    public static int minSubArrayLen2(int target, int[] nums) {

        int result = Integer.MAX_VALUE;
        int sums = 0;

        int sublength = 0;

        for (int i = 0; i < nums.length; i++) {

            sums = 0;
            for (int j = i; j < nums.length; j++) {

                sums = sums + nums[j];
                if (sums >= target) {
                    sublength = j - i + 1;
                    result = result < sublength ? result : sublength;
                    break;
                }
            }

        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }


    //最优解，滑动窗口解决，事件复杂度为 O(n)
    public static int minSubArrayLen3(int target, int[] nums) {

        int result = Integer.MAX_VALUE;

        int sum = 0;

        int sublength = 0;

        int start = 0;
        int end = 0;

        for (; end < nums.length; end++) {
            sum = sum + nums[end];
            while (sum >= target) {
                sublength = end - start + 1;
                result = result > sublength ? sublength : result;

                sum = sum - nums[start];
                start++;
            }

        }

        return result == Integer.MAX_VALUE ? 0 : (result);

    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};

        int ans = minSubArrayLen(8, nums);

        int ans2 = minSubArrayLen2(4, nums);

        int ans3 = minSubArrayLen3(4, nums);

    }


}
