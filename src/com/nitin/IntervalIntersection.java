package com.nitin;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {


    public static void main(String[] args) {

        int f[][] =  {{0,2},{5,10},{13,23},{24,25}};
        int s[][] =  {{1,5},{8,12},{15,24},{25,26}};
        int outPut[][] =  intervalIntersection(f,s);

        for (int i = 0 ; i < outPut.length ; i++){
            System.out.println("[" + outPut[i][0] + "," + outPut[i][1] + "]");
        }
    }



    //
    public static int[][] intervalIntersection(int[][] f, int[][] s) {

        List<int[]> res = new ArrayList();

        if (f.length == 0){ return new int[0][0]; }
        if (s.length == 0){ return new int[0][0]; }

        for (int i = 0 ; i < f.length ; i++){
            //Processing one at a time
            int sfirst = f[i][0];
            int efirst = f[i][1];

            for (int j = 0 ; j < f.length ; j++){

                int ssecond = s[j][0];
                int esecond = s[j][1];

                //Put the continue condition

                //     |||||
                // |||       ||||
                if ( (sfirst > esecond && sfirst > ssecond) || (efirst < ssecond && efirst < esecond)){
                    continue;
                }


                //   |||||
                // |||
                if ( sfirst > ssecond && sfirst == esecond){
                    res.add( new int[]{sfirst,sfirst});
                }

                //   |||||
                //  |||
                else if ( sfirst > ssecond && sfirst < esecond && efirst > esecond){
                    res.add( new int[]{sfirst,esecond});
                }

                //   |||||
                //   |||||
                else if ( sfirst == ssecond && efirst == esecond){
                    res.add( new int[]{sfirst,esecond});
                }

                //   |||||
                //      |||
                else if ( sfirst < ssecond && efirst > ssecond && efirst < esecond){
                    res.add( new int[]{ssecond,efirst});
                }

                //   |||||
                //       |||
                else if ( sfirst < ssecond && efirst == ssecond){
                    res.add( new int[]{efirst,efirst});
                }

                //   |||||
                //  |||||||
                else if ( sfirst > ssecond && efirst < ssecond){
                    res.add( new int[]{sfirst,efirst});
                }
            }
        }
        return res.toArray( new int[res.size()][]);
    }
}
