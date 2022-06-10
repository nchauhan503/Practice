package com.nitin.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(9);
        TreeNode left_left = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        TreeNode right_left = new TreeNode(11);
        TreeNode test = new TreeNode(14);

        root.left = left;
        root.right = right;
        left.left = left_left;
        right.left = right_left;


        boolean m = isValidBST(root);
        //boolean m = isSubtree(root,test);
        System.out.println("isSubtree:" + m);
    }

    public static boolean isValidBST(TreeNode root) {


        List<Integer> vals = new ArrayList<Integer>();

        //get the in order traversal and check if the values are in increasing order
        inOrder(root,vals);

        boolean isValid = false;

        if (vals.size() == 1){
            return true;
        }

        int base = vals.get(0);

        for (int i = 1 ; i < vals.size() ; i++){
            if (vals.get(i) <= base){
                return false;
            }
            base = vals.get(i);
        }

        return true;
    }

    public static void inOrder(TreeNode root, List<Integer> vals){

        if (root == null){
            return;
        }

        inOrder(root.left,vals);
        vals.add(root.val);
        inOrder(root.right,vals);

    }
}
