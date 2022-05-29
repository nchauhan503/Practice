package com.nitin.array;

public class MaxProfit {

    public static void main(String[] args) {
        // write your code here
        int days[] = {2,4,1};  // Output 2
        int sum = maxProfit(days);

        System.out.println("Max sum final :" + sum);
    }

    public static int maxProfit(int[] prices) {

        int profit = 0;

        if (prices.length == 0){
            return profit;
        }

        int buy = prices[0];

        for (int i = 0; i < prices.length; i++){

            if ( buy > prices[i] ){
                buy = prices[i];
            }

            if ( prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}
