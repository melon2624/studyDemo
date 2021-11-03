package com.zx.leetcode.字符串;

import java.util.Arrays;

/**
 * @author : zhangxin
 * @date : 2021-10-29 10:43
 **/
public class IsAnagram242 {

    //先排序然后再比较
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < s.length(); i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    //用26大小的字符数组去记录每个字符出现的次数
    public static boolean isAnagram2(String s, String t) {

       int[] sCounts=new int[26];
       int[] tCounts=new int[26];
       for(char ch: s.toCharArray()){
           sCounts[ch-'a']++;
       }

       for (char ch: t.toCharArray()){
           tCounts[ch-'a']++;
       }

       for (int i=0;i<26;i++){
           if (tCounts[i]!=sCounts[i]){
               return false;
           }
       }
        return true;
    }

    public static void main(String[] args) {
       /* String s = "zhangxin";
        String t = "zhangmiao";
        isAnagram(s, t);*/

         String s = "zhangxin";
        String t = "zhanginx";
      boolean aaa=  isAnagram2(s, t);
        System.out.println(aaa);
    }

}
