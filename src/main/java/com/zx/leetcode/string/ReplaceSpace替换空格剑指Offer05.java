package com.zx.leetcode.string;

/**
 * @author zhangxin
 * @date 2022-02-06 20:29
 */
public class ReplaceSpace替换空格剑指Offer05 {

    //方法一
    public static String replaceSpace(String s) {

        char[] arr = s.toCharArray();
        char[] arr2 = new char[3 * arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                arr2[j++] = '%';
                arr2[j++] = '2';
                arr2[j++] = '0';
            } else {
                arr2[j++] = arr[i];
            }
        }
        return String.valueOf(arr2, 0, j - 1);
    }

    //方法二
    public static String replaceSpace2(String s) {

        char[] arr = s.toCharArray();

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                str.append("%20");
            } else {
                str.append(arr[i]);
            }
        }
        return str.toString();
    }

    //
    public static String replaceSpace3(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if (str.length() == 0) {
            return s;
        }
        int left = s.length() - 1;
        s += str;
        int right = s.length() - 1;

        char[] arr = s.toCharArray();

        while (left >= 0) {
            if (s.charAt(left) == ' ') {

                arr[right--]='0';
                arr[right--]='2';
                arr[right--]='%';
            }else {
                arr[right--]=s.charAt(left);
            }
            left--;

        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String ans = replaceSpace3("We are happy.");
        System.out.println(ans);
    }


}
