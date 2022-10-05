package com.zx.leetcode.queueAndStack;

import java.util.Stack;

/**
 * @author zhangxin
 * @date 2022-02-13 17:26
 */
public class IsValid有效的括号20 {

    public static boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if ('{' == s.charAt(i)) {
                stack.push('{');
            } else if ('}' == s.charAt(i)) {

                if (stack.empty()) {
                    return false;
                }else {
                    char a = stack.pop();
                    if (a != '{') {
                        return false;
                    }
                }


            } else if ('(' == s.charAt(i)) {
                stack.push('(');
            } else if (')' == s.charAt(i)) {

                if (stack.empty()) {
                    return false;
                } else {
                    char a = stack.pop();
                    if (a != '(') {
                        return false;
                    }
                }


            } else if ('[' == s.charAt(i)) {
                stack.push('[');
            } else if (']' == s.charAt(i)) {


                if (stack.empty()) {
                    return false;
                } else {
                    char a = stack.pop();
                    if (a != '[') {
                        return false;
                    }

                }


            }

        }

        if (!stack.empty()) {
            return false;
        } else {
            return true;
        }


    }

    public static void main(String[] args) {

        boolean a = isValid("()[]{}");
        System.out.println(a);
    }

}
