package com.zx.leetcode.queueAndStack;

import java.util.Stack;

/**
 * @author : zhangxin
 * @date : 2021-08-24 19:27
 **/
public class TwoStacksImplementQueue {


    public static class TwoStacksQueue{

        public Stack<Integer> stackPush;

        public Stack<Integer> stackPop;

        public  TwoStacksQueue(){
            stackPush=new Stack<Integer>();
            stackPop=new Stack<Integer>();
        }

        public  void push(Integer data){
             stackPush.push(data);
        }

        public Integer  pop(){
            if (!stackPop.empty()){
               return stackPop.pop();
            }

            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }

            return stackPop.pop();

        }


    }

    public static void main(String[] args) {

        TwoStacksQueue stacksQueue=new TwoStacksQueue();

        stacksQueue.push(1);
        stacksQueue.push(2);
        stacksQueue.push(3);
        stacksQueue.push(4);
        stacksQueue.push(5);
        stacksQueue.push(6);
        while (!stacksQueue.stackPop.empty()||!stacksQueue.stackPush.empty()){
            System.out.print(stacksQueue.pop());
        }

    }

}
