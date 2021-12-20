package com.zx.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429.N叉树的层序遍历
 *
 * @author : zhangxin
 * @date : 2021-11-03 20:04
 **/
public class MultiTreeLevelOrder429 {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node node1 : node.children) {
                    queue.add(node1);
                }
            }
            result.add(list);
        }

        return result;

    }

    public static void main(String[] args) {


    }
}
