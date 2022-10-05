package com.zx.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104.二叉树的最大深度
 *
 * @author : zhangxin
 * @date : 2021-11-03 20:19
 **/
public class MaxDepth二叉树的最大深度104 {


    //递归
    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int maxLeftHeigt = maxDepth(root.left);
        int maxRightHeigt = maxDepth(root.right);
        return maxLeftHeigt > maxRightHeigt ? maxLeftHeigt + 1 : maxRightHeigt + 1;
    }

    //第二遍
    public int maxDepth3(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth3(root.left);
        int rightDepth = maxDepth3(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


    //迭代法
    public static int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int heigt = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            heigt++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return heigt;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        int max = maxDepth2(head);
    }


}
