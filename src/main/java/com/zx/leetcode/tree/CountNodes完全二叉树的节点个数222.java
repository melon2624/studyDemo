package com.zx.leetcode.tree;

/**
 * 222.完全二叉树的节点个数
 *
 * @author : zhangxin
 * @date : 2021-11-09 11:47
 **/
public class CountNodes完全二叉树的节点个数222 {

    //常规方法，没有利用完全二叉树的特点
    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //利用完全二叉树的特点
    public static int countNodes2(TreeNode root) {
        //为空则节点数为0
        if (root == null) {
            return 0;
        }

        //完全二叉树左子树的高度
        TreeNode leftNode = root;
        int leftDepth = 0;
        while (leftNode != null){
            leftDepth++;
            leftNode = leftNode.left;
        }

        TreeNode rightNode = root;
        int rightDepth = 0;
       while(rightNode != null) {
            rightDepth++;
            rightNode = rightNode.right;
        }
        //相等则是完全二叉树
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }

        return countNodes2(root.left) + countNodes2(root.right) + 1;

    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        //    head.right.right = new TreeNode(7);

        int resu = countNodes2(head);
        System.out.println(resu);
    }

}
