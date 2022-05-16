package com.nitin;

public class BrokenBlocks {


    public static void main(String[] args) {

        int lis[][] = {{10,2},{4,2},{-1,-1}};// {{-1,2,3,4},{5,-1,-1,2},{4,3,-1,-1}}; //{{2,5,6},{-1,3,2},{4,-1,5}};
        System.out.println("Maximum gold coins : " + maxGold(lis));
    }

    public static int maxGold(int seq[][]) {

        if (seq.length == 0){
            return 0;
        }

        if (seq.length == 1){
            return findMax(seq[0]);
        }

        int rowToCheck = seq.length - 1;
        for (int i = 1; i < seq.length ; i++) {
            boolean blocked = false;
            if (blocked){
                break;
            }
            int blockedCont = 0;
            for (int j = 0; j < seq[i].length; j++) {
                if ( seq[i][j] < 0){
                    blockedCont++;

                    if (blockedCont == seq[i].length){
                        blocked = true;
                        rowToCheck = i-1;
                        break;
                    }
                    continue;
                }
                int maxSum = 0;
                if ( j - 1 >= 0 && seq[i-1][j-1] > 0){
                    maxSum = Math.max(seq[i-1][j-1] + seq[i][j],maxSum);
                }

                if (seq[i-1][j] >= 0){
                    maxSum = Math.max(seq[i-1][j] + seq[i][j],maxSum);
                }

                if (j + 1 < seq[i].length && seq[i-1][j+1] > 0){
                    maxSum = Math.max(seq[i-1][j+1] + seq[i][j],maxSum);
                }
                if (maxSum > 0) {
                    seq[i][j] = maxSum;
                }

            }
        }
        return findMax(seq[rowToCheck]);
    }


    public static int findMax(int lastRow[]){
        int max = 0;
        for (int i = 0; i < lastRow.length; i++){
            if (max < lastRow[i]){
                max = lastRow[i];
            }
        }

        return max;
    }

    /*public static int subProblem(int row,int seq[][], int col)
    {
        int sum0 = 0;
        int sum1 = 0;
        int sum2 = 0;

        if (row == seq.length){
            return 0;
        }

        int j = col;
            System.out.println("Elements:"+ seq[row][j]);

        if  ( j - 1 >= 0 && seq[row][j-1] > 0) {
            System.out.println("1 i: " + row + " ,j:" + j + " ,Elements:"+ seq[row][j]);
            sum0 =  seq[row][j] + subProblem(row+1,seq,j-1);
        }

        if ( row+1 < seq.length && seq[row+1][j] > 0){
            System.out.println("2 i: " + row + " ,j:" + j + " ,Elements:"+ seq[row][j]);
            sum1 = seq[row][j] + subProblem(row+1,seq,j);
        }

        if ( j+1 < seq[row].length && row+1 < seq.length && seq[row+1][j+1] > 0){
            System.out.println("3 i: " + row + " ,j:" + j + " ,Elements:"+ seq[row][j]);
            sum2 = seq[row][j] + subProblem(row+1,seq,j+1);
        }

        for (int j = col; j < seq[row].length ; j++) {
            System.out.println("Elements:"+ seq[row][j]);

            if  ( j - 1 >= 0 && seq[row][j-1] > 0) {
                System.out.println("1 i: " + row + " ,j:" + j + " ,Elements:"+ seq[row][j]);
                sum0 =  seq[row][j] + subProblem(row+1,seq,j-1);
            }

            if ( row+1 < seq.length && seq[row+1][j] > 0){
                System.out.println("2 i: " + row + " ,j:" + j + " ,Elements:"+ seq[row][j]);
                sum1 = seq[row][j] + subProblem(row+1,seq,j);
            }

            if ( j+1 < seq[row].length && row+1 < seq.length && seq[row+1][j+1] > 0){
                System.out.println("3 i: " + row + " ,j:" + j + " ,Elements:"+ seq[row][j]);
                sum2 = seq[row][j] + subProblem(row+1,seq,j+1);
            }
        }

        System.out.println("Math.max(Math.max(sum0,sum1),sum2):" + Math.max(Math.max(sum0,sum1),sum2));
        return Math.max(Math.max(sum0,sum1),sum2);
    }*/

}
