package com.zx.other;

import com.zx.leetcode.tree.TreeNode;

/**
 * @author : zhangxin
 * @date : 2021-11-11 17:05
 **/
public class Solustion {

    public  static int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public static int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {


        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
      //  head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        sumOfLeftLeaves(head);
    }


}
