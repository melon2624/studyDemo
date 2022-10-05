package com.zx.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : xkdtm
 * @date : 2022-02-17 19:02
 **/
public class LevelOrderBottom二叉树的层序遍历II107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int length = queue.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(list);

        }

        for (int i = 0; i < ans.size() / 2; i++) {
            List<Integer> temp = ans.get(i);
            ans.set(i, ans.get(ans.size() - 1 - i));
            ans.set(ans.size() - 1 - i, temp);

        }

        return ans;
    }

}
