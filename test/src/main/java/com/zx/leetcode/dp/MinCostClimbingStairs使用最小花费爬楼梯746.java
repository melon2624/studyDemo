package com.zx.leetcode.dp;

/**
 * 746. 使用最小花费爬楼
 * @author zhangxin
 * @date 2022-01-06 0:55
 */
public class MinCostClimbingStairs使用最小花费爬楼梯746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    public static void main(String[] args) {

    }
}
