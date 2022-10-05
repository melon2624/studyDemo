package com.zx.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116.填充每个节点的下一个右侧节点指针
 *
 * @author : zhangxin
 * @date : 2021-11-04 11:12
 **/
public class Connect116填充每个节点的下一个右侧节点指针 {

    public static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public static Node connect2(Node root) {

        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {

                Node node = queue.poll();

                if (size == 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }

        return root;
    }


    public static Node connect(Node root) {

        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (i == size - 1) {
                    node.next = null;
                } else {
                    Node node1 = queue.peek();
                    node.next = node1;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        connect(head);
    }

}
