package com.zx.leetcode.string;

/**
 * @author zhangxin
 * @date 2022-02-07 6:53
 */
public class ReverseLeftWords {

    public static String reverseLeftWords(String s, int n) {

        StringBuilder sb = new StringBuilder(s);

        reverseString(sb, 0, s.length() - 1);

        reverseN(sb, n);

        return sb.toString();
    }

    public static void reverseString(StringBuilder s, int start, int end) {

        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void reverseN(StringBuilder s, int n) {

        int start = 0;
        int end = 0;
        while (end < s.length()-n) {
            end++;
        }

        reverseString(s, start, end - 1);
        start = end;
        end = s.length() - 1;
        reverseString(s, start, end);

    }

    public static void main(String[] args) {
        String ans = reverseLeftWords("abcdefg", 2);

        System.out.println(ans);

    }


}
