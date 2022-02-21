package com.zx.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zhangxin
 * @date : 2021-11-11 19:18
 **/
public class SumOfLeftLeaves左叶子之和404 {


    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public static int sumOfLeftLeaves2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return sumOfLeftLeavesHelper(root);

    }

    public static int sumOfLeftLeavesHelper(TreeNode root) {

        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null && node.left.left == null && node.left.right == null) {
                ans = ans + node.left.val;
              //  queue.add(node.left);
            }

            if (node.left!=null){
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

        }

        return ans;

    }


    //深度优先
    public static int dfs(TreeNode root) {

        int ans = 0;
        if (root.left != null) {
            if (isLeafNode(root.left)) {
                ans = ans + root.left.val;
            } else {
                ans = ans + dfs(root.left);
            }
        }
        if (root.right != null) {
            ans = ans + dfs(root.right);
        }
        return ans;
    }

    //广度有限 层序遍历
    public static int SumOfLeftLeaves2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int ans = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            TreeNode node = queue.poll();

            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans = ans + node.left.val;
                } else {
                    queue.add(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;

    }


    public static boolean isLeafNode(TreeNode root) {

        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
     /*   head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);*/

        int ans = sumOfLeftLeaves2(head);

    }


}
