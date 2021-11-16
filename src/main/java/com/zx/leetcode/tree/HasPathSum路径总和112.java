package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-16 14:36
 **/
public class HasPathSum路径总和112 {


    public static boolean hasPathSum(TreeNode root, int targetSum) {

        boolean result = dfs(root, targetSum, 0);

        return result;
    }

    public static boolean dfs(TreeNode root, int targetSum, int sum) {

            if (root==null){
                return false;
            }
            sum=sum+root.val;
            if (root.left==null&&root.right==null){
                if (sum==targetSum){
                    return true;
                }
            }
         boolean l= dfs(root.left,targetSum,sum);
         boolean r= dfs(root.right,targetSum,sum);
         return l||r;
    }


    public static void main(String[] args) {

    }

}
