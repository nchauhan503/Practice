package com.nitin;

public class RobberHouse {

    public static int dp[];

    public static void main(String[] args) {
	// write your code here
        int houses[] = {20,5,10,55,6,10,50};  //,6,10,50
        int sum = maxRobbery(houses); // output should be 55

        System.out.println("Max sum final :" + sum);


        int hval[] = {20,5,10,55,6,10,50};
        System.out.println("Maximum loot value : " + maxLoot(hval));

    }

    public static int maxLoot(int cash[])
    {
        int dp[] = new int[cash.length];

        dp[0] = cash[0];
        dp[1] = Math.max(dp[0],cash[1]);


        for (int i = 2; i < cash.length ; i++){

            dp[i] = Math.max(cash[i] + dp[i-2], dp[i-1]);

        }

        return dp[cash.length - 1];
    }


    public static int maxRobbery(int houses[]){
        dp = new int[houses.length];
        return recursive(houses,0);
    }

    public static int recursive(int[] houses, int i) {
        if ( i >= houses.length){
            return 0;
        }
        if (dp[i] > 0){
            return dp[i];
        }
        int stealCurrent = houses[i] + recursive(houses, i + 2);
        int skipCurrent = recursive(houses, i + 1);

        return dp[i] = Math.max(stealCurrent,skipCurrent);
    }


}



