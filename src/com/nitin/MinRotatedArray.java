package com.nitin;

public class MinRotatedArray {

    public static void main(String[] args) {
        // write your code here

        //int nums[] = {5,1,2,3,4}; // Output:1
        //int nums[] = {4,5,6,7,1}; // Output: 0
        int nums[] = {3,4,5,1,2};  // Output:1
        int sum = findMin(nums);

        System.out.println("Min Sub Array :" + sum);
    }

    // binary search
    public static int findMin(int[] nums) {

        if (nums.length == 1){
            return nums[0];
        }


        if (nums[0] < nums[nums.length - 1]){
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            // check for inflection point
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]){
                return nums[mid];
            }

            // if this condition is true, implies our min element is on the right side
            if (nums[mid] > nums[0]){
                left = mid;
            }else{
                right = mid;
            }
        }

        return 0;
    }

    public static int findMinBrute(int[] nums) {

        if (nums.length == 1){
            return nums[0];
        }


        if (nums[0] < nums[nums.length - 1]){
            return nums[0];
        }

        int left = nums[0];
        int right = nums[nums.length - 1];

        int curr = nums.length - 1;

        while(curr > 0){
            if (nums[curr - 1] > nums[curr] ) {
                return nums[curr];
            }
            curr--;
        }

        return 0;
    }
}
