package com.nitin.tree;

import java.util.*;

public class LevelOrderTraversal {

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

        List<List<Integer>> m = levelOrder(root);

        int i = 1;
        for (List<Integer> ll : m){
            System.out.println("Level:" + i);
            for (int lll : ll){
                System.out.println("val:" + lll);
            }
            i++;
            System.out.println("");
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> l = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null){
            return l;
        }
        q.add(root);

        while (!q.isEmpty()){

            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size ; i++){
                TreeNode peek = q.poll();
                level.add(peek.val);

                if (peek.left != null){
                    q.add(peek.left);
                }

                if (peek.right != null){
                    q.add(peek.right);
                }
            }
            l.add(level);
        }
        return l;
    }
}
