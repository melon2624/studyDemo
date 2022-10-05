package com.zx.leetcode.dp;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author zhangxin
 * @date 2022-01-07 1:17
 */
public class LengthOfLIS最长递增子序列300 {


    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0]=1;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }

}
