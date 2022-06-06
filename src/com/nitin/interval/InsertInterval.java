package com.nitin.interval;

import java.util.LinkedList;

public class InsertInterval {



    public static void main(String[] args) {

        int original[][] =  {{1,3},{6,9}}; int merge[] =  {2,5};  // Output : [[1,5],[6,9]]


        //int original[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}}; int merge[] = {4,8}; // Output : [[1,2],[3,10],[12,16]]

        int outPut[][] =  insert(original,merge);

        for (int i = 0 ; i < outPut.length ; i++){
            System.out.println("Main : [" + outPut[i][0] + "," + outPut[i][1] + "]");
        }

    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> res = new LinkedList<>();

        // 1. Add all the non overlapping intervals which are smaller than newIntervals
        int i = 0; int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]){
          res.add(intervals[i]);
          i++;
        }

        // 2. Merge the overlapping interval
        while (i < n && intervals[i][0] <= newInterval[1] ){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        // 3. Add all the non overlapping intervals which are bigger than newIntervals
        while (i < n){
            res.add(intervals[i]);
            i++;
        }


        return res.toArray(new int[res.size()][]);

    }

}
