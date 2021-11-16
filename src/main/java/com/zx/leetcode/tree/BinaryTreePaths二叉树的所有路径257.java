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
        constructPaths(root, "", pathList);
        return pathList;
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
    public void constructPaths2(TreeNode root, String path, List<String> pathList) {

        return;

    }


    // public  static  void  getDfs(TreeNode root,)

    public static void main(String[] args) {

    }

}
