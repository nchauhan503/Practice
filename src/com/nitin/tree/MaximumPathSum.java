package com.nitin.tree;

public class MaximumPathSum {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(11);
        TreeNode leftt = new TreeNode(12);
        TreeNode right = new TreeNode(13);

        root.left = left;
        root.right = right;
        left.left = leftt;

        int m =  maxPathSum(root);

        System.out.println(" MaximumPathSum :" + m);

    }

    public static int maxPathSum(TreeNode root) {

        int res[] = new int[1];
        res[0] = root.val;
        dfs(res,root);

        return res[0];
    }

    public static int dfs(int[] res,TreeNode root){

        if (root == null){
            return 0;
        }


        int leftMax = Math.max(dfs(res,root.left),0);
        int rightMax = Math.max(dfs(res,root.right),0);

        res[0] = Math.max(res[0],root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax,rightMax);

    }
}
