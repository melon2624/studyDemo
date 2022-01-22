package com.zx.leetcode.dp;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * @author : xkdtm
 * @date : 2022-01-19 09:52
 **/
public class CoinChange零钱兑换322 {

    public int coinChange(int[] coins, int amount) {

        if (amount <= 0 || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }


        return dp[amount]==amount+1?-1:dp[amount];
    }

    public static void main(String[] args) {

    }
}
