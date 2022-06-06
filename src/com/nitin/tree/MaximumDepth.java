package com.nitin.tree;

public class MaximumDepth {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(11);
        TreeNode leftt = new TreeNode(12);
        TreeNode right = new TreeNode(13);

        root.left = left;
        root.right = right;
        left.left = leftt;

        int m =  maxDepth(root);

        System.out.println(" Max Depth :" + m);

    }

    public static int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        int right = maxDepth(root.right) + 1;
        int left = maxDepth(root.left) + 1;

        return Math.max(right,left);
    }
}
