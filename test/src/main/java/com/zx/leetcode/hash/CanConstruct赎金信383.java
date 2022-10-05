package com.zx.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022-02-05 17:02
 */
public class CanConstruct赎金信383 {

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                Integer num = map.get(magazine.charAt(i));
                map.put(magazine.charAt(i), num + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            Integer a = map.get(ransomNote.charAt(j));
            if (a == null) {
                return false;
            } else if (a == 1) {
                map.remove(ransomNote.charAt(j));
            } else {
                map.put(ransomNote.charAt(j), a - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        boolean ans = canConstruct("aa", "ab");
        System.out.println(ans);
    }

}
