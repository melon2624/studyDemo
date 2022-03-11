package com.zx.leetcode.tree;

import java.util.*;

/**
 * 257. 二叉树的所有路径
 *
 * @author : zhangxin
 * @date : 2021-11-11 14:55
 **/
public class BinaryTreePaths二叉树的所有路径257 {


    public static List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<String> pathList = new ArrayList<>();
        // constructPaths(root, "", pathList);
        binaryTreePathHelper2(root, "", pathList);
        return pathList;
    }

    public static void binaryTreePathHelper2(TreeNode root, String str, List<String> list) {

        if (root == null) {
            //  list.add(str);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(str);

        stringBuilder.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(stringBuilder.toString());
          //  binaryTreePathHelper2(root, stringBuilder.toString(), list);
        } else {
            stringBuilder.append("->");
            binaryTreePathHelper2(root.left, stringBuilder.toString(), list);
            binaryTreePathHelper2(root.right, stringBuilder.toString(), list);
        }
    }


    public static void binaryTreePathHelper(TreeNode root, String str, List<String> list) {

        if (root.left == null && root.right == null) {

            str = str + root.val;

            // str.substring(0, str.length() - 2);
            list.add(str);
            return;
        }

        str = str + root.val + "->";
        binaryTreePathHelper(root.left, str, list);
        binaryTreePathHelper(root.right, str, list);
    }


    public static void constructPaths(TreeNode root, String path, List<String> pathList) {

        if (root == null) {
            return;
        }
        StringBuffer sb = new StringBuffer(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            pathList.add(sb.toString());
        } else {
            sb.append("->");
            constructPaths(root.left, sb.toString(), pathList);
            constructPaths(root.right, sb.toString(), pathList);
        }

    }

    //非递归遍历
    //TODO
    public void constructPaths2(TreeNode root, String path, List<String> pathList) {

        return;

    }


    // public  static  void  getDfs(TreeNode root,)

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
       // head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        //List<String> list = binaryTreePaths(head);

        List<String> list = binaryTreePaths(head);
    }

}
