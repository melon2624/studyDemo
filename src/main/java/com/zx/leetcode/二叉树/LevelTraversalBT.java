package com.zx.leetcode.二叉树;

import com.zx.leetcode.链表.ReverseList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author : zhangxin
 * @date : 2021-09-02 19:11
 **/
public class LevelTraversalBT {


    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            this.value = v;
        }
    }

    public static  void  level(Node head){

        if (head==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            head=queue.poll();
            System.out.println(head.value);
            if (head.left!=null){
                queue.add(head.left);
            }
            if (head.right!=null){
                queue.add(head.right);
            }
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        level(head);
        System.out.println("========");
    }

}
