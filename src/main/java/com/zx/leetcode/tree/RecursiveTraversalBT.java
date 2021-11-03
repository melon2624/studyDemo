package com.zx.leetcode.tree;

/**
 * 二叉树的递归遍历
 *
 * @author : zhangxin
 * @date : 2021-08-31 14:30
 **/
public class RecursiveTraversalBT {

    public static class Node {
        int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //先序遍历打印节点
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public  static  void  in(Node head){

        if (head==null){
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    public  static  void  pos(Node head){
        if (head==null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
    }

}
