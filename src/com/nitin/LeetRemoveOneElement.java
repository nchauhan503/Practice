package com.nitin;

import java.util.ArrayList;
import java.util.List;

public class LeetRemoveOneElement {


    public static void main(String[] args) {

        int lis[] = {1,1,1}; //{2,3,1,2}; //{1,2,10,5,7}
        System.out.println("Is valid array : " + canBeIncreasing(lis));

        //
        //[[-1,0,1],[-1,1,0],[-1,2,-1],[-1,-1,2],[0,-1,1],[0,1,-1],[0,1,-1],[0,2,-2],[0,-1,1],[0,-2,2],[1,-1,0],[1,0,-1],[1,0,-1],[1,-1,0],[2,-1,-1],[2,0,-2],[2,-1,-1],[2,-2,0],[-1,-1,2],[-1,0,1],[-1,1,0],[-1,2,-1],[-2,0,2],[-2,2,0]]

        List<List<Integer>> l = new ArrayList<List<Integer>>();
    }

    public static boolean canBeIncreasing(int[] nums) {

        int count = 0; //for keeping the count of how many digits have been removed
        int comp = nums[0]; //this var will be used to compare the order
        if(nums.length==2){
            return true; //if length of array is 2, by removing any one it will be strictly increasing
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i]<=comp){
                count++; //First break found
                if(i==1 || nums[i]>nums[i-2]) //Now we have to check if it's a second element because if yes then we can simply remove the first element and array will be increasing or if we can remove the bigger one by checking i-2
                    comp = nums[i];
                if(count>1) return false; //if we have already update twice then return false
            } else comp=nums[i];  //compare is shifted to next
        }
        return true;
    }
}
