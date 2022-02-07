package com.zx.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangxin
 * @date 2022-02-07 4:25
 */
public class SeverseWords {

    public static String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    public static String reverseWords2(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    public static StringBuilder removeSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder str = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ' || str.charAt(str.length() - 1) != ' ') {
                str.append(c);
            }
            left++;
        }

        return str;
    }


    public static void reverseString(StringBuilder str, int start, int end) {

        while (start < end) {
            char c = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, c);
            start++;
            end--;
        }
    }

    public static void reverseEachWord(StringBuilder str) {

        int start = 0;
        int end = 0;
        while (start < str.length()) {

            while (end<str.length() &&str.charAt(end)!=' '){
                end++;
            }
            reverseString(str,start,end-1);
            start=end+1;
            end=start;
        }
    }


    /*private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }*/

    /**
     * 反转字符串指定区间[start, end]的字符
     */
   /* public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }*/

  /*  private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
*/
    public static void main(String[] args) {

        String a = reverseWords2("the  sky is blue");
    }
}
