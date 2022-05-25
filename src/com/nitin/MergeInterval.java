package com.nitin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {

        int f[][] = {{1,10},{2,6},{1,10},{15,18}} ;// {{5,5},{1,3},{3,5},{4,6},{1,1},{3,3},{5,6},{3,3},{2,4},{0,0}}; // [[1,6],[8,10],[15,18]]
        //  {{1,100},{2,6},{1,10},{15,18}}; // output should be : [[1,100]]
        int outPut[][] =  mergeIntersection(f);

        for (int i = 0 ; i < outPut.length ; i++){
            System.out.println("Main : [" + outPut[i][0] + "," + outPut[i][1] + "]");
        }
    }


    // optimal
    public static int[][] mergeIntersection(int[][] v) {

        List<int[]> res = new ArrayList();

        // sort the array
        Arrays.sort(v, (a, b) -> a[0] - b[0]);

        for (int i = 0 ; i < v.length ; i++){
            System.out.println(" Sorted array : [" + v[i][0] + "," + v[i][1] + "]");
        }

        int secondf = -1;
        int seconds = -1;
        for (int i = 0 ; i < v.length ; i++){

            int currstart = v[i][0];
            int currend = v[i][1];

            for (int j = i + 1 ; j < v.length ; j++){

                // intersection condition
                if ( currend >= v[j][0] ) {
                    currstart = v[i][0];
                    currend = Math.max(v[i][1],v[j][1]);
                }
            }

            if (  ( secondf == -1 & seconds == -1) || seconds < currstart ) {
                System.out.println("prev 0:" + secondf);
                System.out.println("prev 1:" + seconds);

                System.out.println("new 0:" + currstart);
                System.out.println("new 1:" + currend);
                res.add(new int[]{currstart, currend});
                secondf = currstart;
                seconds = currend;

            }
        }

        return res.toArray(new int[res.size()][]);

    }
}
