package com.nitin;

public class ProductExceptSelf {

    public static void main(String[] args) {
        // write your code here
        int nums[] = {1,2,3,4};  // Output : {24,12,8,6}
        int sum[] = productExceptSelf(nums);

        for( int i : sum){
            System.out.println("Produt except self :" + i);
        }
    }


    public static int[] productExceptSelf(int[] nums) {

        int forward[] = new int[nums.length];
        int backward[] = new int[nums.length];


        forward[0] = nums[0];

        System.out.println("forward[0]:" + forward[0]);
        for (int i = 1; i < nums.length ; i++){
            forward[i] = forward[i-1] * nums[i];
            System.out.println("forward[i]:" + forward[i]);
        }


        backward[nums.length - 1] = nums[nums.length - 1];
        System.out.println("backward[3]:" + backward[nums.length - 1]);
        for (int i = nums.length - 2 ; i >= 0 ; i--){
            backward[i] = backward[i+1] * nums[i];
            System.out.println("backward[i]:" + backward[i]);
        }


        for (int i = 0; i < nums.length ; i++){

            if (i == 0){
                nums[i] = backward[1];
                continue;
            }

            if (i == nums.length - 1){
                nums[i] = forward[nums.length - 2];
                continue;
            }

            nums[i] = forward[i-1] * backward[i+1];

        }


        return nums;
    }


    // Not optimal, n2
    public static int[] productExceptSelfNotOptimal(int[] nums) {

        int product = 1;

        int isZeroed = 0;
        for (int i = 0; i < nums.length ; i++){


            if (nums[i] != 0){
                product *= nums[i];
            }
            else {
                isZeroed++;
            }
        }

        for (int i = 0; i < nums.length ; i++){

            if ( isZeroed > 1){
                nums[i] = 0;
                continue;
            }


            if (nums[i] != 0){
                if (isZeroed == 1){
                    nums[i] = 0;
                }else{
                    nums[i] = product/nums[i];
                }

            }else{
                nums[i] = product;
            }
        }


        return nums;
    }

}
