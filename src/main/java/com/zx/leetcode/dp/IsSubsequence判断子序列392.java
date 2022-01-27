package com.zx.leetcode.dp;

/**
 * leetcode 392
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * @author : xkdtm
 * @date : 2022-01-24 15:08
 **/
public class IsSubsequence判断子序列392 {

    //方法一双指针遍历O(n)

    //方法二:动态规划
    public boolean isSubsequence(String s, String t) {

        int[][] dp = new int[s.length()][t.length()];

        if (s.charAt(0) == t.charAt(0)) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = dp[0][0];
        }
        for (int j = 0; j < t.length(); j++) {
            dp[0][j] = dp[0][0];
        }

        for (int i = 1; i < s.length(); i++) {

            for (int j = 1; j < t.length(); j++) {

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length()][t.length()]==s.length()?true:false;
    }


}
