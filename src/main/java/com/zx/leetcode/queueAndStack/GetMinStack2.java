package com.zx.leetcode.queueAndStack;

import java.util.Stack;

/**
 * @author : zhangxin
 * @date : 2021-09-10 16:43
 **/
public class GetMinStack2 {

    public static class MyStack {

        public Stack<Integer> stackData;

        public Stack<Integer> stackMin;

        public MyStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }


        public void push(Integer data) {
            stackData.push(data);
            if (stackMin.empty()) {
                stackMin.push(data);
            } else {
                Integer temp = stackMin.peek();
                if (temp < data) {
                    stackMin.push(temp);
                } else {
                    stackMin.push(data);
                }
            }
        }

        public Integer pop() {
            if (stackData.empty()) {
                throw new RuntimeException("stack is empty");
            } else {
                stackMin.pop();

                return stackData.pop();
            }
        }

        public Integer getMin() {
            if (stackData.empty()) {
                throw new RuntimeException("stack is empty");
            } else {
                return stackMin.peek();
            }
        }


    }


}
