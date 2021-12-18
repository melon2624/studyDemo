package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-16 14:53
 **/
public class BuildTree从中序与后序遍历序列构造二叉树106 {

    //自己的写法，递归
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode buildTree1(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {

        if (inRight - inLeft < 0) {
            return null;
        }
        int val = postorder[postRight];
        TreeNode root = new TreeNode(val);
        if (inRight - inLeft == 0) {
            return root;
        }
        int rootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode left = buildTree1(inorder, inLeft, rootIndex - 1, postorder, postLeft, postLeft + (rootIndex - inLeft - 1));
        TreeNode right = buildTree1(inorder, rootIndex + 1, inRight, postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        root.left = left;
        root.right = right;
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode node = buildTree(inorder, postorder);
    }

}
