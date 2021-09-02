package com.zx.leetcode.队列和栈;

import java.util.Stack;

/**
 * @author : zhangxin
 * @date : 2021-08-26 14:58
 **/
public class SortStack {

    //栈排序
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();

        while (!stack.empty()){
            if (stack1.empty()){
                stack1.push(stack.pop());
            }else {
                Integer data=stack.pop();
                while (!stack1.empty()&&data>stack1.peek()){
                    stack.push(stack1.pop());
                }
                stack1.push(data);
            }
        }

        while (!stack1.empty()){
            stack.push(stack1.pop());
        }
    }


    public static void main(String[] args) {

        Stack<Integer> stack=new Stack<>();
        stack.push(7);
        stack.push(6);
        stack.push(45);
        stack.push(1);
        stack.push(14);

        sortStackByStack(stack);

        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }

}
