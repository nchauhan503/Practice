package com.nitin;

public class SearchRotatedArray {

    public static void main(String[] args) {
        // write your code here

        int nums[] = {5,1,2,3,4}; int target = 1; // Output:1
        //int nums[] = {4,5,6,7,0,1,2}; int target = 7;  // Output:3
        //int nums[] = {1,3}; int target = 1;  // Output:0
        int sum = findElement(nums,target);

        System.out.println("Min Sub Array :" + sum);
    }

    // binary search
    public static int findElement(int[] nums, int target) {

        if (nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }


        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if (target == nums[left]){
                return left;
            }

            if (target == nums[right]){
                return right;
            }

            if (target == nums[mid]){
                return mid;
            }


            if (left == mid || right == mid){
                return -1;
            }


            if ( nums[left] < target && target < nums[mid]  &&  nums[left] < nums[mid]){
               right = mid;
            } else if (nums[mid] < target && nums[right] > target && nums[mid] < nums[right]) {
                left = mid;
            } else{
                right--;
                left++;
            }

        }

        return -1;
    }
}
