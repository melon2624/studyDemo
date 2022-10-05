package com.zx.leetcode.queueAndStack;

import java.util.Stack;

/**
 * @author : zhangxin
 * @date : 2021-08-26 10:49
 **/
public class GetMinStack最小栈155 {

    public static class Mystack {

        public Stack<Integer> stackData;
        public Stack<Integer> stackMin;

        public Mystack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(Integer data) {
            stackData.push(data);
            if (stackMin.empty()) {
                stackMin.push(data);
            } else if (stackMin.peek() > data) {
                stackMin.push(data);
            } else {
                stackMin.push(stackMin.peek());
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
            if (stackMin.empty()) {
                throw new RuntimeException("stack is empty");
            } else {
                return stackMin.peek();
            }
        }
    }

    public static void main(String[] args) {
        Mystack mystack = new Mystack();

        mystack.push(5);
        mystack.push(4);
        mystack.push(9);
        mystack.push(1);

        System.out.print(mystack.getMin());
    }


}
