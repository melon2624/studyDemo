package com.zx.leetcode.greedy;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 输入：nums = [1]
 * 输出：1
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * @author : xkdtm
 * @date : 2021-12-14 11:10
 **/
public class MaxSubArray最大子数组和53 {

    //暴力求解,双重for循环
    public static int maxSubArray1(int[] nums) {

        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                count = count + nums[j];
                result = count > result ? count : result;
            }
        }
        return result;
    }


    public static int maxSubArray2(int[] nums) {

        int result = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count < 0) {
                count = 0;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int r = maxSubArray1(nums);
        int rr=maxSubArray2(nums);
        System.out.println(rr);
    }
}
