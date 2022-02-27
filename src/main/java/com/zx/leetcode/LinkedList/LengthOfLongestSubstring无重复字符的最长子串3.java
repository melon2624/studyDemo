package com.zx.leetcode.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangxin
 * @date 2022-02-17 1:54
 */
public class LengthOfLongestSubstring无重复字符的最长子串3 {

    public static int lengthOfLongestSubstring(String s) {

        if ("".equals(s)) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = Integer.MIN_VALUE;

        while (right < s.length()) {

            char c = s.charAt(right);
            right++;
            if (map.get(c) != null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }

            while (map.get(c) > 1) {
                char c1 = s.charAt(left);
                left++;
                map.put(c1, map.get(c1) - 1);
            }
            len = Math.max(len, right - left);
        }

        return len;
    }

    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("au");
    }


}
