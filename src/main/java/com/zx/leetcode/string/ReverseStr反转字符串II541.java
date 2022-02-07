package com.zx.leetcode.string;

/**
 * @author zhangxin
 * @date 2022-02-06 19:52
 */
public class ReverseStr反转字符串II541 {

    public static String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2 * k) {


            if (i + k > s.length()) {
                reverse(arr, i, s.length()-1);
            } else {
                reverse(arr, i, i+k-1);
            }

        }

        return String.valueOf(arr);
    }

    public static void reverse(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        String a = reverseStr("abcdefg", 2);
        System.out.println(a);
    }


}
