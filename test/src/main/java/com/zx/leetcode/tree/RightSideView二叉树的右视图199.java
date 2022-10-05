package com.zx.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : xkdtm
 * @date : 2022-02-17 19:11
 **/
public class RightSideView二叉树的右视图199 {


    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int len = queue.size();

            while (len > 0) {
                TreeNode node = queue.poll();
                if (len == 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                len--;
            }
        }


        return result;
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
      //  head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
       // head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        List<Integer> result = rightSideView(head);

    }

}
