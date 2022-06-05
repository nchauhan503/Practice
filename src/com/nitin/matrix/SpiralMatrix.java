package com.nitin.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        //int lis[][] =  {{1,2,3},{4,5,6},{7,8,9}}; // Output: [1,2,3,6,9,8,7,4,5]

        int lis[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; // Output : [1,2,3,4,8,12,11,10,9,5,6,7]

        List<Integer> s = spiralOrder(lis);

        for (int i : s) {
            System.out.println("int:" + i);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiral = new ArrayList<Integer>();

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        int count = matrix[0].length * matrix.length;

        while ( left <= right && top <= bottom ) {
            // row : straight right
            for (int i = left ; i <= right; i++) {
                int a = matrix[top][i];
                spiral.add(matrix[top][i]);
                count--;
            }
            top += 1;

            if ( count == 0 ){
                break;
            }

            // col : straight bottom
            for (int j = top; j <= bottom; j++) {
                int a = matrix[j][right];
                spiral.add(matrix[j][right]);
                count--;
            }
            right -= 1;

            if ( count == 0 ){
                break;
            }

            // row : straight left
            for (int i = right ; i >= left; i--) {
                int a = matrix[bottom][i];
                spiral.add(matrix[bottom][i]);
                count--;
            }
            bottom -= 1;

            if ( count == 0 ){
                break;
            }

            // col : straigh top
            for (int j = bottom ; j >= top; j--) {
                int a = matrix[j][left];
                spiral.add(matrix[j][left]);
                count--;
            }
            left += 1;
        }
        return spiral;
    }
}
