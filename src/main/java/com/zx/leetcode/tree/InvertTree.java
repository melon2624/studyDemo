package com.zx.leetcode.tree;

/**
 * 226.翻转一棵二叉树
 *
 * @author : zhangxin
 * @date : 2021-09-18 16:59
 **/
public class InvertTree {


    public static class Node {

        int value;

        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void  InvertTree(Node head){
        if (head==null){
            return;
        }

        Node temp=head.left;
        head.left=head.right;
        head.right=temp;

        InvertTree(head.left);
        InvertTree(head.right);

    }


    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(3);
        head.right = new Node(7);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(8);

        InvertTree(head);


    }

}
