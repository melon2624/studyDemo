package com.zx.leetcode.tree;

/**
 * 236. 二叉树的最近公共祖先
 * @author : zhangxin
 * @date : 2021-11-18 10:01
 **/
public class LowestCommonAncestor二叉树的最近公共祖先236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if (left!=null&&right!=null){
            return root;
        }else   if (left!=null&&right==null){
            return left;
        } else    if (left==null&&right!=null){
            return right;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
