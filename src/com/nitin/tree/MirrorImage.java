package com.nitin.tree;

public class MirrorImage {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(9);
        TreeNode left_left = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        TreeNode right_left = new TreeNode(11);

        root.left = left;
        root.right = right;
        left.left = left_left;
        right.left = right_left;

        TreeNode m = invertTree(root);

        System.out.println(" MirrorImage :" + m);

    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null){
            return root;
        }

        //Switch values
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
