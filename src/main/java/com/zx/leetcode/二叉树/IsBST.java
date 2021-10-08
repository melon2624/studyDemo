package com.zx.leetcode.二叉树;

import java.util.ArrayList;

/**
 * 98. 验证二叉搜索树
 *
 * @author : zhangxin
 * @date : 2021-09-16 13:46
 **/
public class IsBST {


    public static class Node {

        public int value;

        public Node left;

        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    //中序遍历判断是否是搜索二叉树
    public static boolean isBST1(Node head) {

        if (head == null) {
            return true;
        }
        ArrayList<Node> arrayList = new ArrayList<>();
        in(head, arrayList);//中序遍历
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i).value > arrayList.get(i + 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void in(Node head, ArrayList arr) {

        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    //递归判断是否搜索二叉树
    public static Info isBST2(Node head) {
        if (head == null) {
            return null;
        }

        Info left = isBST2(head.left);
        Info right = isBST2(head.right);
        int min = head.value;

        if (left != null) {
            min = Math.min(min, left.min);
        }
        if (right != null) {
            min = Math.min(min, right.min);
        }
        int max = head.value;
        if (left != null) {
            max = Math.max(max, left.max);
        }
        if (right != null) {
            max = Math.max(max, right.max);
        }
        boolean isBST = true;
        if (left != null && !left.isBST) {
            isBST = false;
        }
        if (left != null && left.max > head.value) {
            isBST = false;
        }
        if (right != null && !right.isBST) {
            isBST = false;
        }
        if (right != null && right.min <= head.value) {
            isBST = false;
        }

        return new Info(isBST, max, min);
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    static Integer pre=Integer.MIN_VALUE;

    public static boolean isBST3(Node head) {
        if (head == null) {
            return true;
        }

        if (!isBST3(head.left)){
            return false;
        }

        if (head.value < pre) {
            return false;
        }

        return isBST3(head.right);

    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(3);
        head.right = new Node(7);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(8);

        boolean a = isBST1(head);
        Info info = isBST2(head);
        System.out.println(a);
        System.out.println(info.isBST);

        System.out.println(isBST3(head));
    }


}
