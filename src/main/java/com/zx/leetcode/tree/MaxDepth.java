package com.zx.leetcode.tree;

/** 104.二叉树的最大深度
 * @author : zhangxin
 * @date : 2021-11-03 20:19
 **/
public class MaxDepth {


    //递归
   public static  int maxDepth(TreeNode root){

       if (root==null){
           return 0;
       }
       int maxLeftHeigt=maxDepth(root.left);
       int maxRightHeigt=maxDepth(root.right);
       return  maxLeftHeigt>maxRightHeigt?maxLeftHeigt+1:maxRightHeigt+1;
   }


   //迭代法
   public  static int maxDepth2(TreeNode root){

       return 0;
   }


}
