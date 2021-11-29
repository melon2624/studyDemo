package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-16 20:16
 **/
public class MergeTrees合并二叉树617 {


    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }
        int rootVal = 0;
        if (root1 != null && root2 != null) {
            rootVal = root1.val + root2.val;
        }else {
            if (root1!=null){
                rootVal=root1.val;
            }else {
                rootVal=root2.val;
            }
        }


        TreeNode root=new TreeNode(rootVal);
        root.left=mergeTrees(root1==null?null:root1.left,root2==null?null:root2.left);
        root.right=mergeTrees(root1==null?null:root1.right,root2==null?null:root2.right);

        return root;

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(3);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(5);
       /* head.left.right = new TreeNode(5);
        head.left.left.left=new TreeNode(6);*/

        TreeNode head1 = new TreeNode(2);
        head1.left = new TreeNode(1);
        head1.right = new TreeNode(3);
        head1.left.right = new TreeNode(4);
        head1.right.right = new TreeNode(7);

        mergeTrees(head,head1);
    }
}
