package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-17 16:38
 **/
public class GetMinimumDifference二叉搜索树的最小绝对差530 {

    static Integer min = Integer.MAX_VALUE;

    static TreeNode pre = null;

    public static void getMinimumDifference(TreeNode root) {

        if (root == null) {
            return;
        }

        getMinimumDifference(root.left);

        if (pre != null) {
            int x = root.val - pre.val;
            if (min > x) {
                min = x;
            }
            pre=root;
        } else {
            pre = root;
        }
        getMinimumDifference(root.right);

    }


    public static void main(String[] args) {
        //543,384,652,null,445,null,699
        TreeNode head = new TreeNode(543);
        head.left = new TreeNode(384);
        head.right = new TreeNode(652);
        head.left.left = null;

        head.left.right = new TreeNode(445);
        head.right.left = null;
        head.right.right = new TreeNode(699);

        getMinimumDifference(head);

    }


}
