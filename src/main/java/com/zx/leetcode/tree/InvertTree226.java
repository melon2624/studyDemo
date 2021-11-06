package com.zx.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 226.翻转一棵二叉树
 *
 * @author : zhangxin
 * @date : 2021-09-18 16:59
 **/
public class InvertTree226 {


    public static class Node {

        int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void InvertTree(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head.left;
        head.left = head.right;
        head.right = temp;

        InvertTree(head.left);
        InvertTree(head.right);

    }

    //第二遍反转二叉树 递归法
    public static TreeNode invertTree2(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    //第一遍 首次用迭代法 层序遍历,前序遍历和后续遍历都可以
    public static TreeNode invertTree3(TreeNode root) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                node.left = right;
                node.right = left;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }

    //前序遍历
    public static TreeNode invsertTree4(TreeNode root) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                node.left = right;
                node.right = left;
                stack.add(node.right);
                stack.add(node.left);
            }
        }
        return root;

    }

    public static void main(String[] args) {
        //第一遍递归反转
        /*Node head = new Node(1);
        head.left = new Node(3);
        head.right = new Node(7);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(8);

        InvertTree(head);*/

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        invertTree2(head);

    }

}
