package com.nitin.matrix;

public class RotateImage {

    public static void main(String[] args) {

        // Rotate the image clockwise
        int lis[][] = {{1,2,3},{4,5,6},{7,8,9}}; // Output: [[7,4,1],[8,5,2],[9,6,3]]
        //int lis[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(lis);

        for ( int i = 0; i < lis.length; i++){
            for ( int j = 0; j < lis[i].length; j++){
                System.out.println("i:" + i + " j:" + j + " value:" + lis[i][j]);
            }
        }
    }

    public static void rotate(int[][] matrix) {


        // first switch diagonally then reverse it from right to left

        // switch diagonally
        for ( int i = 0; i < matrix.length; i++){
            for ( int j = 0; j < matrix.length; j++){

                if ( j > i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        System.out.println("Switch done");
        // reverse from right to left
        for ( int i = 0; i < matrix.length; i++){
            for ( int j = 0; j < matrix.length; j++){

                if ( j < matrix.length/2  ){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - 1 - j];
                    matrix[i][matrix.length - 1 - j] = temp;
                }
            }
        }

        System.out.println("Reverse done");


    }
}
