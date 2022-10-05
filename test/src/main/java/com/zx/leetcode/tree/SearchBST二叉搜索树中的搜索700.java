package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-17 14:14
 **/
public class SearchBST二叉搜索树中的搜索700 {

    public static TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
