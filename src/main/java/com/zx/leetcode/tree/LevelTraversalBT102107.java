package com.zx.leetcode.tree;

import java.util.*;

/**
 * 102 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
 * 107 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 二叉树的层序遍历
 *
 * @author : zhangxin
 * @date : 2021-09-02 19:11
 **/
public class LevelTraversalBT102107 {


    public static void level(Node head) {

        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    //最普通的层序遍历第二遍
    public static void level2(Node head) {

        if (head == null) {
            System.out.println("二叉树为空");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //102每一层的数据都放入一个list 代码第一遍
    public static List<List<Integer>> levelOrder(Node head) {

        List<List<Integer>> list = new ArrayList<>();

        if (head == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList();

        queue.add(head);
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> orderList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                orderList.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(orderList);
        }
        return list;
    }

    //107 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历
    public static List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> orderList = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                orderList.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(orderList);

        }
        int size1 = list.size();
        for (int i = 0; i < list.size() / 2; i++) {
            List<Integer> temp = list.get(i);
            list.set(i, list.get(size1 - 1 - i));
            list.set(size1 - 1 - i, temp);
        }
        return list;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        // level2(head);
        System.out.println("========");

        List<List<Integer>> list = levelOrder(head);

        System.out.println("============");
        List<List<Integer>> listList = levelOrderBottom(head);

    }

}
