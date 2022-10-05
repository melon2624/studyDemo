package com.zx.leetcode.dp;

/**
 * 只能卖一次
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * @author zhangxin
 * @date 2022-01-22 21:47
 */
public class MaxProfit买卖股票的最佳时机122I {
    //可以暴力枚举二层for循环
    //常规解法一层循环
    public static int maxProfit(int[] prices) {

        Integer min = prices[0];

        Integer ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            ans = ans > (prices[i] - min) ? ans : (prices[i] - min);
        }
        return ans;
    }

    //动态规划
    public static int maxProfit1(int[] prices) {

        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};

        int ans = maxProfit(arr);

        int ans2 = maxProfit1(arr);

        System.out.println(ans2);
    }


}
