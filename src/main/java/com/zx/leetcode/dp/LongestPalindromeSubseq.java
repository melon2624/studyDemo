package com.zx.leetcode.dp;

/**
 * @author : xkdtm
 * @date : 2022-01-27 16:53
 **/
public class LongestPalindromeSubseq {

    public static int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

      /*  for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }*/

        for (int i = s.length() - 1; i >= 0; i--) {

            for (int j = i; j < s.length(); j++) {

                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j) && i != j) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }

        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        int ans = longestPalindromeSubseq("cbbd");
        System.out.println(ans);
    }

}
