package com.nitin.matrix;

import java.util.ArrayList;
import java.util.List;

public class SetZeroes {

    public static void main(String[] args) {

        //int lis[][] =  {{0,1,2,0},{3,4,0,2},{1,3,1,5}}; // Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        int lis[][] =  {{1,0,3}}; // Output: [ 0,0,0]
        //int lis[][] = [[1,1,1],[1,0,1],[1,1,1]]; // Output: [[1,0,1],[0,0,0],[1,0,1]]

        setZeroes(lis);

        for ( int i = 0; i < lis.length; i++){
            for ( int j = 0; j < lis[i].length; j++){
                System.out.println("i:" + i + " j:" + j + " value:" + lis[i][j]);
            }
        }
    }


    public static void setZeroes(int[][] lis) {
        int row = 1;
        int col = 1;

        for ( int i = 0; i < lis.length; i++){
            if( lis[i][0] == 0){
                row = 0;
            }
        }

        for ( int i = 0; i < lis[0].length; i++){
            if( lis[0][i] == 0){
                col = 0;
            }
        }

        for ( int i = 1; i < lis.length; i++){
            for ( int j = 1; j < lis[i].length; j++){

                if (lis[i][j] == 0){
                    lis[i][0] = 0;
                    lis[0][j] = 0;
                }
            }
        }

        // updating the matrix from (1-len) (1-len) to 0 based on flag
        for ( int i = 1; i < lis.length; i++){
            for ( int j = 1; j < lis[i].length; j++){

                if( lis[i][0] == 0 || lis[0][j] == 0){
                    lis[i][j] = 0;
                }
            }
        }

        // updating all the 0th row to 0
        if ( row == 0) {
            for (int i = 0; i < lis.length; i++) {
                lis[i][0] = 0;
            }
        }

        // updating all the 0th col to 0
        if ( col == 0) {
            for (int i = 0; i < lis[0].length; i++) {
                lis[0][i] = 0;
            }
        }
    }


    public static void setZeroesMN(int[][] lis) {

        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();

        for ( int i = 0; i < lis.length; i++){
            for ( int j = 0; j < lis[i].length; j++){

                if (lis[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
                System.out.println("i:" + i + " j:" + j + " value:" + lis[i][j]);
            }
        }

        lis = zeros(lis,row,column);
        System.out.println("set " + lis);

    }

    private static int[][] zeros(int[][] lis, List<Integer> row, List<Integer> column) {


        for ( int i = 0; i < lis.length; i++){
            for ( int j = 0; j < lis[i].length; j++){

                if (row.contains(i) || column.contains(j)){
                    lis[i][j] = 0;
                }

                System.out.println("i:" + i + " j:" + j + " value:" + lis[i][j]);
            }
        }

        return lis;
    }
}
