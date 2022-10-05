package com.zx.leetcode.queueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangxin
 * @date 2022-02-13 17:12
 */
public class MyStack用队列实现栈225 {

    Queue<Integer> queue1 = null;
    Queue<Integer> queue2 = null;


    public MyStack用队列实现栈225() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {

        while (queue1.size() > 1) {

            queue2.add(queue1.poll());
        }

        Integer a = queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;


        return a;
    }

    public int top() {
        while (queue1.size() > 1) {

            queue2.add(queue1.poll());
        }

        Integer a = queue1.peek();

        queue2.add(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return a;
    }

    public boolean empty() {

        return queue1.isEmpty();
    }

    public static void main(String[] args) {

    }


}
