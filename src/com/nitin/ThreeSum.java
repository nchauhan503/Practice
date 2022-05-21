package com.nitin;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        int lis[] = {-1,0,0,1,1,2,2,-1,-2,-2};

        // Ans Output: [[-2,0,2],[-1,-1,2],[-1,0,1]]

        System.out.println("Three sum arraylist : " + threeSum(lis));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> res  = new HashSet<List<Integer>>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);


        for (int i : nums){
            System.out.println("i:" + i);
        }

        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){

                int sum =nums[j]+nums[k];
                if(sum == -nums[i]){

                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++; k--;
                }
                else if ( sum >-nums[i]) k--;
                else if (sum<-nums[i]) j++;
            }

        }
        return new ArrayList<>(res);
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
