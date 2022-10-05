package com.zx.leetcode.flashBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 * @author : zhangxin
 * @date : 2021-11-22 19:18
 **/
public class LetterCombinations电话号码的字母组合17 {

    static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    static List<String> resultList = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {

        if (!"".equals(digits) && digits != null) {
            letterCombinationsHelper(digits, "", 1);
        }

        return resultList;
    }

    //第二遍
    public static List<String> letterCombinations2(String digits) {

        if ("".equals(digits) || digits == null) {
            return resultList;
        }
        letterCombinationsHelper2(digits, "", 0);


        return resultList;

    }

    private static void letterCombinationsHelper2(String digits, String targetString, int startIndex) {


        if (targetString.length() == digits.length()) {
            resultList.add(targetString.toString());
            return;
        }

        String currentKey = phoneMap.get(digits.charAt(startIndex));
        char[] currentChar = currentKey.toCharArray();
        for (int i = 0; i < currentChar.length; i++) {
            StringBuilder newtarget = new StringBuilder(targetString).append(currentChar[i]);
            letterCombinationsHelper2(digits, newtarget.toString(), startIndex + 1);
        }


    }


    public static void letterCombinationsHelper(String digits, String targetString, int startIndex) {
        if (targetString.length() == digits.length()) {
            resultList.add(targetString.toString());
            return;
        }
        String currentKey = phoneMap.get(digits.charAt(startIndex - 1));
        char[] keyChar = currentKey.toCharArray();
        for (int i = 0; i < keyChar.length; i++) {
            StringBuilder newTargetString = new StringBuilder(targetString).append(keyChar[i]);
            letterCombinationsHelper(digits, newTargetString.toString(), startIndex + 1);
        }
    }

    public static void main(String[] args) {
        List reslut = letterCombinations2("");
    }
}
