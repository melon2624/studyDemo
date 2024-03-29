package com.zx.leetcode.tree;

/**
 * leetcode 官方树节点
 *
 * @author : zhangxin
 * @date : 2021-11-03 18:40
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
