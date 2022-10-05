package com.zx.leetcode.queueAndStack;

import java.util.Stack;

/**
 * @author zhangxin
 * @date 2022-02-13 17:04
 */
public class MyQueue用栈实现队列232 {

    Stack<Integer> stackIn = null;
    Stack<Integer> stackOut = null;

    public MyQueue用栈实现队列232() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {

        if (!stackOut.empty()) {
            Integer a = stackOut.pop();

            return a;
        } else {

            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }

            return stackOut.pop();

        }

    }

    public int peek() {
        if (!stackOut.empty()) {
            Integer a = stackOut.peek();

            return a;
        } else {

            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }

            return stackOut.peek();

        }
    }

    public boolean empty() {

        return stackIn.empty() && stackOut.empty();
    }

    public static void main(String[] args) {


    }


}
