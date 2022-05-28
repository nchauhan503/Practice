package com.nitin;

public class ProductExceptSelf {

    public static void main(String[] args) {
        // write your code here
        int nums[] = {2,4,1};  //{2,4,1}
        int sum[] = productExceptSelf(nums); // output should be 55

        for( int i : sum){
            System.out.println("Produt except self :" + i);
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int product = 1;

        int forwrad[] = new int[nums.length];
        int backward[] = new int[nums.length];


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
