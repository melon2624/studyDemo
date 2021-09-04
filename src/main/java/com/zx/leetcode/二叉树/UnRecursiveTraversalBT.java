package com.zx.leetcode.二叉树;

import java.util.Stack;

/**
 * 非递归遍历二叉树
 *
 * @author : zhangxin
 * @date : 2021-08-31 14:53
 **/
public class UnRecursiveTraversalBT {

    public static class Node {
        int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //前序遍历
    public static void pre(Node head) {

        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //后序遍历
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);

        while (!stack1.empty()) {
            Node node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.empty()) {
            System.out.println(stack2.pop().value);
        }
    }

    //中序遍历
    public static void in(Node head) {

        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();

        while (!stack.empty()||head!=null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head=head.right;
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
        System.out.println("前序遍历");
        pre(head);
        System.out.println("========");
        System.out.println("后序遍历");
        pos(head);

    }

}
