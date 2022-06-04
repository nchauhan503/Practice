package com.nitin.matrix;

public class SetZeroes {

    public static void main(String[] args) {

        int lis[][] =  {{0,1,2,0},{3,4,5,2},{1,3,1,5}}; // Output: 40
        //{{3,2,-1}, {4,-1,-1}, {-1, -1,7},{2,3,8}};// {{-1,2,3,4},{5,-1,-1,2},{4,3,-1,-1}}; //{{2,5,6},{-1,3,2},{4,-1,5}};
        setZeroes(lis);

        for ( int i = 0; i < lis.length; i++){
            for ( int j = 0; j < lis[i].length; j++){
                System.out.println("i:" + i + " j:" + j + " value:" + lis[i][j]);
            }
        }
    }


    public static void setZeroes(int[][] matrix) {

    }


}
