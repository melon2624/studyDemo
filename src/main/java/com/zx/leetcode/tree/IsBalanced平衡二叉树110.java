package com.zx.leetcode.tree;

/**
 * @author : zhangxin
 * @date : 2021-11-09 15:33
 **/
public class IsBalanced平衡二叉树110 {

    public static class Info {
        int depth;
        boolean balanced;

        public Info() {
        }

        public Info(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public boolean isBalanced() {
            return balanced;
        }

        public void setBalanced(boolean balanced) {
            this.balanced = balanced;
        }
    }

    public static Info isBalanced1(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info left = isBalanced1(root.left);
        Info right = isBalanced1(root.right);
        Info info = new Info();
        int dept = left.depth > right.depth ? left.depth + 1 : right.depth + 1;
        info.setDepth(dept);
        if (!left.balanced || !right.balanced) {
            info.setBalanced(false);
        } else {
            if (Math.abs(left.depth - right.depth) > 1) {
                info.balanced = false;
            } else {
                info.balanced = true;
            }
        }
        return info;
    }


    public static boolean isBalanced2(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean leftBalance = isBalanced2(root.left);
        boolean rightBalance = isBalanced2(root.right);

        int leftHeigt = heigt(root.left);
        int rightHeigt = heigt(root.right);

        return Math.abs(leftHeigt - rightHeigt) <= 1 && leftBalance && rightBalance;

    }

    public static boolean isBalanced3(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean leftBalance = isBalanced3(root.left);
        boolean rightBalance = isBalanced3(root.right);

        int leftHeigt = heigt2(root.left);
        int rightHeigt = heigt2(root.right);

        return leftBalance && rightBalance && Math.abs(leftHeigt - rightHeigt) <= 1;

    }

    public static int heigt2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeigt = heigt2(root.left);
        int rightHeigt = heigt2(root.right);

        int rootHeigt = Math.max(leftHeigt, rightHeigt) + 1;
        return rootHeigt;
    }


    private static int heigt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeigt = heigt(root.left);
        int rightHeigt = heigt(root.right);

        int rootHeight = Math.max(leftHeigt, rightHeigt) + 1;

        return rootHeight;
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.left.left.left = new TreeNode(6);
        //head.right.left = new TreeNode(6);


        //  Info info=isBalanced1(head);

        boolean balanced = isBalanced2(head);

        System.out.println(balanced);

    }


}
