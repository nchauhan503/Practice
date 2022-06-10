package com.nitin.tree;

public class SubTreePresent {

    public static void main(String[] args) {


        /*TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(9);
        TreeNode left_left = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        TreeNode right_left = new TreeNode(11);
        TreeNode test = new TreeNode(14);

        root.left = left;
        root.right = right;
        left.left = left_left;
        right.left = right_left;*/


        /*TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        three.right = five;
        three.left = four;
        four.right = two;
        four.left = one;*/

        TreeNode one = new TreeNode(1);
        TreeNode oneone = new TreeNode(1);

        one.right = oneone;

        boolean m = isSubtree(one,oneone);
        //boolean m = isSubtree(root,test);
        System.out.println("isSubtree:" + m);
    }


    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if ( subRoot == null){
            return true;
        }

        if (root == null){
            return false;
        }

        if ( isSame(root,subRoot)){
            return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    private static boolean isSame(TreeNode sub, TreeNode subRoot) {

        if (sub == null && subRoot == null){
            return true;
        }

        if (sub != null && subRoot != null && sub.val == subRoot.val){
            return isSame(sub.left,subRoot.left) && isSame(sub.right,subRoot.right);
        }

        return false;

    }

    public static boolean isSubtreeOld(TreeNode root, TreeNode subRoot) {

        boolean isSubtree = false;
        // first check if the root.val exits
        TreeNode sub = isRootPresent(root,subRoot.val);

        // implies the subRoot val not found
        if (sub == null){
            return false;
        }

        // if the root node exists, check if all the values are present.
        isSubtree = isSame(sub,subRoot);

        return isSubtree;
    }

    private static TreeNode isRootPresent(TreeNode root, int val) {

        if (root.val == val){
            return root;
        }else{
            if (root.left != null) {
                return isRootPresent(root.left, val);
            }

            if (root.right != null) {
                return isRootPresent(root.right, val);
            }
        }

        return null;
    }


}
