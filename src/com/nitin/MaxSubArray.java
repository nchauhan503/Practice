package com.nitin;

public class MaxSubArray {

    public static void main(String[] args) {
        // write your code here

        //int nums[] = {-1,-2};  // Output : -1
        //int nums[] = {-1,-2, -3};  // Output : 6 (4,-1,2,1)
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};  // Output : 6 (4,-1,2,1)
        int sum = maxSubArray(nums);

        System.out.println("Max Sub Array :" + sum);
    }

    public static int maxSubArray(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = nums[0];
        //int max = Math.max(Integer.MIN_VALUE,nums[0]);


        for (int i = 1; i < nums.length; i++){

            if (sum + nums[i] < sum){
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            maxSum = Math.max(sum,maxSum);

        }
        return maxSum;
    }


    public static int maxSubArrayNotWorking(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = nums[0];
        int max = Math.max(Integer.MIN_VALUE,nums[0]);

        for (int i = 1; i < nums.length; i++){
            max = Math.max(max,nums[i]);
            if ( sum < nums[i] ){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            maxSum = Math.max(sum,maxSum);
        }
        return Math.max(Math.max(max,maxSum),maxSum);
    }
}
