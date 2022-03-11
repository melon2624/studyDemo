package com.zx.leetcode.tree;

/**
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 654.最大二叉树
 *
 * @author : zhangxin
 * @date : 2021-09-18 17:59
 **/
public class ConstructMaximumBinaryTree最大二叉树654 {

    public static int arrayMax(int[] nums, int left, int right) {

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public static int arrayMax2(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static TreeNode constructMaximumBinaryTree2(int[] nums, int left, int right) {
        if (left - right < 0) {
            return null;
        } else if (left == right) {
            return new TreeNode(nums[left]);
        } else {

            int maxIndex = arrayMax2(nums, left, right);
            TreeNode treeNode = new TreeNode(nums[maxIndex]);
            TreeNode leftNode = constructMaximumBinaryTree2(nums, left, maxIndex - 1);
            TreeNode rightNode = constructMaximumBinaryTree2(nums, maxIndex + 1, right);
            treeNode.left = leftNode;
            treeNode.right = rightNode;
            return treeNode;
        }
    }


    public static TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {

        if (right - left < 0) {
            return null;
        }
        if (right - left == 0) {
            return new TreeNode(nums[left]);
        }
        int maxIndex = arrayMax(nums, left, right);

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = constructMaximumBinaryTree(nums, left, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);

        return root;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        //int max= arrayMax(nums);

        // constructMaximumBinaryTree(nums);
    }

}
