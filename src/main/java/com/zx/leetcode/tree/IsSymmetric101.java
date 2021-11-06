package com.zx.leetcode.tree;

/**
 * 101. 对称二叉树
 *
 * @author : zhangxin
 * @date : 2021-11-05 17:42
 **/
public class IsSymmetric101 {


    public static boolean dfc(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val!=right.val){
            return false;
        }

      return   dfc(left.left,right.right)&&dfc(left.right,right.left);

    }


    public static  boolean  isSymmetric(TreeNode root){


        if (root==null){
            return true;
        }

        return dfc(root.left,root.right);

    }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(2);
        root.left.right=null;
        root.right.left=new TreeNode(2);
        root.right.right=null;

      boolean a=  isSymmetric(root);

    }

}
