package com.nitin;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {


    public static void main(String[] args) {

        int f[][] =  {{3,5},{9,20}}; // {{5,10}};// {{0,2},{5,10},{13,23},{24,25}};
        int s[][] =  {{4,5},{7,10},{11,12},{14,15},{16,20}}; // {{3,10}};// {{1,5},{8,12},{15,24},{25,26}};
        int outPut[][] =  intervalIntersection(f,s);

        for (int i = 0 ; i < outPut.length ; i++){
            System.out.println("Main : [" + outPut[i][0] + "," + outPut[i][1] + "]");
        }
    }


    // optimal
    public static int[][] intervalIntersection(int[][] f, int[][] s) {
        List<int[]> res = new ArrayList();

        int i = 0, j = 0;

        while( i < f.length && j < s.length ){


            int l = Math.max(f[i][0],s[j][0]);
            int h = Math.min(f[i][1],s[j][1]);

            if (l <= h){
                res.add(new int[]{l,h});
            }

            if (f[i][1] > s[j][1]){
                j++;
            }else{
                i++;
            }

        }

        return res.toArray( new int[res.size()][]);

    }


    // not optimal
    public static int[][] intervalIntersectionNotOptimal(int[][] f, int[][] s) {

        List<int[]> res = new ArrayList();

        if (f.length == 0){ return new int[0][0]; }
        if (s.length == 0){ return new int[0][0]; }

        for (int i = 0 ; i < f.length ; i++){
            //Processing one at a time
            int sfirst = f[i][0];
            int efirst = f[i][1];

            System.out.println("Processing first: [" + sfirst + "," + efirst + "]");


            for (int j = 0 ; j < s.length ; j++){

                int ssecond = s[j][0];
                int esecond = s[j][1];

                System.out.println("Processing second : [" + ssecond + "," + esecond + "]");

                //Put the continue condition

                //   |||||
                // |||
                if ( sfirst > ssecond && sfirst == esecond){
                    res.add( new int[]{sfirst,sfirst});
                    System.out.println("[" + sfirst + "," + sfirst + "]");
                }

                //   |||||
                //  |||
                else if ( sfirst > ssecond && sfirst < esecond && efirst > esecond){
                    res.add( new int[]{sfirst,esecond});
                    System.out.println("[" + sfirst + "," + esecond + "]");
                }

                //   |||||||
                //    |||||
                else if ( sfirst < ssecond && efirst > esecond){
                    res.add( new int[]{ssecond,esecond});
                    System.out.println("[" + sfirst + "," + esecond + "]");
                }

                //   |||||
                //  ||||||
                else if ( sfirst > ssecond && efirst == esecond ){
                    res.add( new int[]{sfirst,esecond});
                    System.out.println("[" + sfirst + "," + esecond + "]");
                }

                //   |||||
                //   |||
                else if ( sfirst == ssecond && efirst > esecond ){
                    res.add( new int[]{sfirst,esecond});
                    System.out.println("[" + sfirst + "," + esecond + "]");
                }

                //   |||||
                //   |||||
                else if ( sfirst == ssecond && efirst == esecond){
                    res.add( new int[]{sfirst,esecond});
                    System.out.println("[" + sfirst + "," + esecond + "]");
                }

                //  |||||
                //  ||||||
                else if ( sfirst == ssecond && efirst < esecond ){
                    res.add( new int[]{sfirst,efirst});
                    System.out.println("[" + sfirst + "," + efirst + "]");
                }

                //   |||||
                //     |||
                else if ( efirst == esecond && sfirst < esecond ){
                    res.add( new int[]{ssecond,esecond});
                    System.out.println("[" + ssecond + "," + esecond + "]");
                }

                //   |||||
                //      |||
                else if ( sfirst < ssecond && efirst > ssecond && efirst < esecond){
                    res.add( new int[]{ssecond,efirst});
                    System.out.println("[" + ssecond + "," + efirst + "]");
                }

                //   |||||
                //       |||
                else if ( sfirst < ssecond && efirst == ssecond){
                    res.add( new int[]{efirst,efirst});
                    System.out.println("[" + efirst + "," + efirst + "]");
                }

                //   |||||
                //  |||||||
                else if ( sfirst > ssecond && efirst < esecond){
                    res.add( new int[]{sfirst,efirst});
                    System.out.println("[" + sfirst + "," + efirst + "]");
                }
            }
        }
        return res.toArray( new int[res.size()][]);
    }
}
