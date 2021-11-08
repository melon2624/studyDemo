package com.zx.leetcode.tree;

import java.util.Stack;

/**
 * 二叉树的前中后序层序遍历第二遍
 *
 * @author : zhangxin
 * @date : 2021-11-01 10:28
 **/
public class UnRecursiveTraversalBT22222 {


    //先序遍历
    public static void pre(Node node) {

        if (node == null) {
            System.out.println("二叉树为空");
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            Node data = stack.pop();
            System.out.println(data.value);

            if (data.right != null) {
                stack.push(data.right);
            }

            if (data.left != null) {
                stack.push(data.left);
            }
        }
    }

    //中序遍历
    public static void in(Node node) {
        if (node == null) {
            System.out.println("二叉树为空");
        }
        Stack<Node> stack = new Stack();
        Node cur = node;
        /**
         * 简单来说，stack不为空，意思是有上级节点。cur不等于空，
         * 意思是还能往下走。所以，这一句是说，上级有节点，或者还能往下走，就说明没遍历完，要继续
         */
        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                Node node1 = stack.pop();
                System.out.println(node1.value);
                cur = node1.right;
            }
        }
    }

    //中序遍历第三遍
    public static void in3(TreeNode root) {

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (!stack.empty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            System.out.println(node.val);
            cur = node.right;
        }
    }

    //后续遍历
    public static void pos(Node node) {

        if (node == null) {
            System.out.println("二叉树为空");
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.empty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.empty()) {
            Node node1 = stack2.pop();
            System.out.println(node1.value);
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
        //  pre(head);
        // in(head);
        //  pos(head);
       // in3(head);
    }

}
