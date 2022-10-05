package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-16 19:04
 **/
public class BuildTree从前序与中序遍历序列构造二叉树105 {


    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public static TreeNode buildTree1(int[] preorder, int preLeft, int preRight, int[] inorder, int intLeft, int inRight) {

        if (preRight - preLeft < 0) {
            return null;
        }
        if (preRight - preLeft == 0) {
            return new TreeNode(preorder[preLeft]);
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = intLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
            }
        }
        root.left = buildTree1(preorder, preLeft + 1, preLeft + (rootIndex - intLeft), inorder, intLeft, rootIndex - 1);
        root.right = buildTree1(preorder, preLeft + 1 + (rootIndex - intLeft), preRight, inorder, rootIndex + 1, inRight);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = buildTree(preorder, inorder);
    }

}
