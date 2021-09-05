package com.zx.leetcode.二叉树;

/**
 * 114. 二叉树展开为链表
 *
 * @author zhangxin
 * @date 2021/9/4 14:46
 */
public class FlattenBinaryTreeToLinkedList {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    public static void solustion(Node head) {

        if (head == null) {
            return ;
        }
    }

}
