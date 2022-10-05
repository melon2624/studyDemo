package com.zx.leetcode.dp;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * @author : xkdtm
 * @date : 2022-01-19 10:42
 **/
public class Change零钱兑换518 {

    public int change(int amount, int[] coins) {


        int[][] dp = new int[amount + 1][coins.length + 1];


        for (int i = 0; i <= amount + 1; i++) {
            dp[0][i] = 0;
        }
        return 0;
    }

}
