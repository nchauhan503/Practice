package com.nitin;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        // write your code here
        int []array = {1,2,3,4,5};

        printSubets(array);

    }

    static void printSubets(int[] a) {

        double totalSets = Math.pow(new Double(2),new Double(a.length));

        for (int i= 0; i < totalSets; i++){
            List<Integer> output = new ArrayList<Integer>();
            for (int j=0; j< a.length; j++){
                if ( (i & (1 << j)) !=0  ){
                    output.add(a[j]);
                }
            }
            System.out.println("For:"+ i + " subset is:" + output);
            output = null;

        }


    }


}
