package com.zx.leetcode.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : zhangxin
 * @date : 2021-11-08 15:49
 **/
public class 输出频率最高且最先出现的字符 {


    public static char fun(String str) {

        char[] ch = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Integer count = map.get(ch[i]);
            if (count == null) {
                map.put(ch[i], 1);
            } else {
                map.put(ch[i], count + 1);
            }
        }
        int maxCount = 1;
        Character result = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                result = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return result;
    }


    public static char fun2(String str) {

        char[] ch = str.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();

        Character character = ch[0];
        int maxCount = 1;
        for (int i = ch.length - 1; i >= 0; i--) {
            Integer count = map.get(ch[i]);
            if (count == null) {
                map.put(ch[i], 1);
            } else {
                map.put(ch[i], count + 1);
                if (count + 1 >= maxCount) {
                    maxCount = count + 1;
                    character = ch[i];
                }
            }
        }

        return character;

    }

    public static void main(String[] args) {

        String str = "hello world,every body";

        char result = fun2(str);
        System.out.println(result);
    }

}
