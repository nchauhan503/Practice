package com.nitin.interval;

import java.util.Arrays;

public class NonOverlappingInterval {

    public static void main(String[] args) {

        //int input[][] = {{1,2},{2,3},{3,4},{1,3}};  // Output 1
        //int input[][] = {{1,2},{1,2},{1,2}};  // Output 2
        //int input[][] = {{1,2},{2,3}};  // Output 0
        int input[][] = {{1,100},{11,22},{1,11},{2,12}}; // Output 2
        int outPut =  eraseOverlapIntervals(input);
        System.out.println("Output:" + outPut);
    }


    public static int eraseOverlapIntervals(int[][] intervals) {

        // sort the array first
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        int count = 0;

        int temp = intervals[0][1];

        for ( int i = 1; i < intervals.length; i++){
            if (temp > intervals[i][0] ){ // over lapping
                count++;
                temp = Math.min(temp, intervals[i][1]);
            } else { // not overlapping
                temp = intervals[i][1];
            }
        }


        return count;
    }

    public static int eraseOverlapIntervalsInCorrect(int[][] intervals) {

        // sort the array first
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        int count = 0;

        int temp[] = new int[]{intervals[0][0],intervals[0][1]};

        for ( int i = 1; i < intervals.length; i++){
            if ( temp[0] >= intervals[i][0] || temp[1] > intervals[i][1] ){
                count++;
            }
            temp[0] = Math.max(temp[0],intervals[i][0]);
            temp[1] = Math.max(temp[1],intervals[i][1]);
        }


        return count;
    }
}
