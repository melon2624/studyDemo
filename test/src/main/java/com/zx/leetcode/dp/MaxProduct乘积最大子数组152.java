package com.zx.leetcode.dp;

/**
 * 乘积最大子数组152
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author : xkdtm
 * @date : 2022-01-12 15:30
 **/
public class MaxProduct乘积最大子数组152 {

    public int maxProduct(int[] nums) {

        int max = nums[0];
        int temp = 0;
        int imax = nums[0];
        int imin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                temp = imax;
                imax = Math.max(nums[i], nums[i] * imin);
                imin = Math.min(nums[i], nums[i] * temp);
            } else {
                imax = Math.max(nums[i], nums[i] * imax);
                imin = Math.min(nums[i], nums[i] * imin);
            }
            max = Math.max(imax, max);
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
