package com.zx.leetcode.tree;

/**
 * @author : xkdtm
 * @date : 2022-02-21 11:43
 **/
public class MinDepth二叉树的最小深度111 {


    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }


        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);

        if (root.left==null&&root.right!=null){
            return minRight+1;
        }else if (root.right==null&&root.left!=null){
            return minLeft+1;
        }else {
            return minLeft<minRight?minLeft+1:minRight+1;
        }

    }

    public static void main(String[] args) {


    }

}
