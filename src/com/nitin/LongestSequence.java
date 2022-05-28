package com.nitin;

public class LongestSequence {

    public static void main(String[] args) {

        int lis[] = {20,5,10,55,6,10,50}; // Output: 4
        System.out.println("Longest Subsequence count : " + maxLis(lis));

    }

    public static int maxLis(int seq[])
    {

        return subProblem(-1, 0, seq);

    }

    public static int subProblem(int prev, int curr, int seq[])
    {
        if (curr == seq.length){
            return 0;
        }

        int a = 0;
        if (prev == -1 || seq[curr] > seq[prev] ){
            a = 1 + subProblem(curr,curr+1,seq);
        }
        int b = subProblem(prev,curr+1,seq);


        return Math.max(a,b);
    }

}
