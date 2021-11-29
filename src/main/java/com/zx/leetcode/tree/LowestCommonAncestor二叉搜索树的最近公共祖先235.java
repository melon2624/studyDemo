package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-18 15:57
 **/
public class LowestCommonAncestor二叉搜索树的最近公共祖先235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null){
            return null;//p q肯定在root树里面，所以这一步不可能会执行
        }
        if (root==q||root==p){
            return root;
        }

        if (root.val>p.val&&root.val>q.val){
            return  lowestCommonAncestor(root.left,p,q);
        }
        if (root.val<p.val&&root.val<p.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if ((p.val<root.val&&q.val>root.val)||(q.val<root.val&&p.val>root.val)){
            return root;
        }
       return null;
    }

}
