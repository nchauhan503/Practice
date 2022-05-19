package com.nitin;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int lis[] = {-1,0,1,2,-1,-4,-2};

        // Ans Output: [[-2,0,2],[-1,-1,2],[-1,0,1]]

        System.out.println("Three sum arraylist : " + threeSum(lis));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        Map<Integer,Map<Integer,Integer>> toAdd = new HashMap<Integer,Map<Integer,Integer>>();

        if (nums == null || nums.length == 0 || nums.length == 1){
            return outer;
        }

        Arrays.sort(nums);

        for (int i : nums){
            System.out.println("Array:" + i);
        }

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0){
                continue;
            }

            int j = i +1;
            int k = nums.length - 1;
            while (j<k) {

                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> inner = new ArrayList<Integer>();
                    inner.add(nums[i]);
                    inner.add(nums[j]);
                    inner.add(nums[k]);
                    Collections.sort(inner);
                    if (!listExist(inner, toAdd)) {
                        outer.add(inner);
                    }
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > -nums[i]){
                    k--;
                } else {
                    j++;
                }
            }

        }

        return outer;
    }

    private static boolean listExist(List<Integer> i,Map<Integer,Map<Integer,Integer>> toAdd) {
        if (toAdd.containsKey(i.get(0))) {
            Map<Integer, Integer> secondCheck = toAdd.get(i.get(0));
            if (secondCheck.containsKey(i.get(1))) {
                return true;
            } else {
                secondCheck.put(i.get(1), i.get(2));
                return false;
            }
        } else {
            Map<Integer, Integer> toAddd = new HashMap<Integer, Integer>();
            toAddd.put(i.get(1), i.get(2));
            toAdd.put(i.get(0), toAddd);
            return false;
        }
    }
}
