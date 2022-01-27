package com.zx.leetcode.dp;

import java.util.*;

/**
 * leetcode 647
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * @author : xkdtm
 * @date : 2022-01-25 16:20
 **/
public class CountSubstrings回文子串647 {

    public static boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;
        if (s.length() % 2 == 0) {
            while (j - i > 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        } else {
            while (i != j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return true;
    }

    public int countSubstrings1(String s) {

        return 0;
    }


    public static int countSubstrings(String s) {

        if (s.length() == 1) {
            return 1;
        }
        boolean[][] dp = new boolean[s.length() ][s.length() ];

     /*   for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = false;
        }
        for (int j = 0; j <= s.length(); j++) {
            dp[j][0] = false;
        }
*/
        int result = 0;
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i; j<=s.length()-1; j++) {
                if (s.charAt(i ) != s.charAt(j )) {
                    dp[i][j] = false;
                } else {
                    if ((j - i) > 1) {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j]) {
                            result++;
                        }
                    } else {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void fun(String s) {

        Stack stack = new Stack();
        Queue queue = new LinkedList();
        int i = 0;
        while (i < s.length()) {
            char a = s.charAt(0);
            if ((a > 'A' && a < 'Z') || (a > 'a' && a < 'z') || (a > '0' && a < '9')) {
                if (a > 'A' && a < 'Z') {
                    //a=(char) a+32;
                    a = (char) (a - '0' + 32 + '0');
                    stack.push(a);
                }
            }
        }
        Stack<Character> stack1 = new Stack();

        while (!stack.empty()) {
            //   char  c=stack.empty();

        }


    }

    public static void main(String[] args) {

        int result = countSubstrings("aaa");

        System.out.println(result);
       /* String test = "A man, a plan, a canal: Panama";
        String a = "abbc";
        boolean ans = isPalindrome(a);
        //A 65
        //a 97
        int i = 'Z';
        System.out.println(i);
        fun(test);
        Queue queue = new LinkedList();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        while (!queue.isEmpty()) {
        System.out.println(queue.poll());
        }
       */
        /*char b = 'B';
        char a1 = (char) (b - '0' + 32 + '0');
        System.out.println(a1);*/
    }

}
