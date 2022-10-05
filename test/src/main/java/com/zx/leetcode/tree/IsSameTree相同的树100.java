package com.zx.leetcode.tree;

/**
 * 100. 相同的树
 *
 * @author : zhangxin
 * @date : 2021-11-05 19:07
 **/
public class IsSameTree相同的树100 {


    //递归
    public static boolean isSameTree(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean l = isSameTree(left.left, right.left);
        boolean r = isSameTree(left.right, right.right);

        return l && r;
    }

    //层序遍历也可以


    public static void main(String[] args) {

    }


}
