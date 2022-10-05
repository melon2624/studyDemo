package com.zx.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 第二遍
 *
 * @author : xkdtm
 * @date : 2022-02-17 18:47
 **/
public class LevelOrder层序遍历102 {


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }



        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            while (length > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                length--;
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        List<List<Integer>> listList = levelOrder(head);

    }


}
