package com.zx.greedy;

/**
 * @author : xkdtm
 * @date : 2021-12-14 19:00
 **/
public class MaxProfit买卖股票的最佳时机122 {

    public static int maxProfit(int[] prices) {

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max((prices[i] - prices[i - 1]), 0);
        }

        return result;
    }
}
