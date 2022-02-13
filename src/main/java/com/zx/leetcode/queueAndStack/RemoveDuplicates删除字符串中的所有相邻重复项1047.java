package com.zx.leetcode.queueAndStack;

import java.util.Stack;

/**
 * @author zhangxin
 * @date 2022-02-14 1:08
 */
public class RemoveDuplicates删除字符串中的所有相邻重复项1047 {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                char peek = stack.peek();
                if (peek == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }


        if (!stack.empty()) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack1 = new Stack<>();

          /*  while (!stack.empty()) {
                stack1.push(stack.pop());
            }

            while (!stack1.empty()) {
                sb.append(stack1.pop());
            }
            */

            for (Character c:stack){
                sb.append(c);
            }

            return sb.toString();

        } else {
            return "";
        }


    }


    public String removeDuplicates1(String s) {

        StringBuilder sb = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (top >= 0 || s.charAt(i) == sb.charAt(top)) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(s.charAt(i));
                top++;
            }
        }
        return sb.toString();

    }
}
