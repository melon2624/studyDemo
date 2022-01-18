package com.zx.leetcode.dp;

/**
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @author : xkdtm
 * @date : 2022-01-13 11:37
 **/
public class NumDecodings解码方法91 {

    public static int numDecodings(String s) {

        if ("0".equals(s.substring(0, 1))) {
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i>1 && (s.charAt(i-2)!='0')&& (((s.charAt(i - 2) - '0') * 10 + (s.charAt(i-1) - '0')) <= 26)) {
                dp[i] = dp[i - 2] +dp[i];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String a = "226";
        String b="10";
        String c="2101";
        int ans = numDecodings(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(ans);
        System.out.println(ans);
        System.out.println(ans);
    }

}
