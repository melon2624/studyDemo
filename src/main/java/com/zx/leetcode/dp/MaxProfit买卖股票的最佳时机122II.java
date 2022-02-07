package com.zx.leetcode.dp;

/**
 * 可以无数次买卖
 *
 * @author zhangxin
 * @date 2022-01-23 15:57
 */
public class MaxProfit买卖股票的最佳时机122II {

    //动态规划，还可以贪心
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        //0表示手里没有股票，1表示没有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static int maxProfit2(int[] prices) {

        int[] profit = new int[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            profit[i - 1] = prices[i] - prices[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < profit.length; i++) {
            if (profit[i] > 0) {
                ans += profit[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int ans2 = maxProfit2(arr);
    }

}
