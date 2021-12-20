package com.zx.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 *
 * @author : zhangxin
 * @date : 2021-11-16 09:56
 **/
public class FindBottomLeftValue找树左下角的值513 {

    static Integer maxValue = Integer.MIN_VALUE;
    static Integer mexDept = -1;

    public static int findBottomLeftValue(TreeNode root) {

        dfs(root, 1);
        return maxValue;

    }

    private static void dfs(TreeNode root, int deep) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {//此时为子节点
            if (deep > mexDept) {//比前面深度大的时候记录下来
                maxValue = root.val;
                mexDept = deep;
            }
        }
        //隐藏着回溯
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }

    //层序遍历找左下角的值
    public static int findBottomLeftValue2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        TreeNode node = new TreeNode(-1);
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return node.val;
    }


    public static void main(String[] args) {

    }


}
