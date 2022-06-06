package com.nitin.tree;

import java.util.List;

public class SameTree {



    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(11);
        TreeNode leftt = new TreeNode(12);
        TreeNode right = new TreeNode(13);

        root.left = left;
        root.right = right;
        left.left = leftt;

        boolean m =  isSameTree(root,root);

        System.out.println(" Is Same Tree :" + m);

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {


        // To check if it's a same tree
        // Recursive call
        // If the values are same implies : they are both same

        if (p == null && q == null){
            return true;
        }

        if (p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }


        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }





    public static void inOrder(TreeNode root, List<Integer> l){

        if (root == null){
            return;
        }

        inOrder(root.left,l);
        l.add(root.val);
        inOrder(root.right,l);


    }
}
