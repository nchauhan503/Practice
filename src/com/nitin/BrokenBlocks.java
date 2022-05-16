package com.nitin;

public class BrokenBlocks {


    public static void main(String[] args) {

        int lis[][] =  {{-1,2,3}, {4,-1,-1}, {-1, -1,7},{2,3,8}};//{{3,2,-1}, {4,-1,-1}, {-1, -1,7},{2,3,8}};// {{-1,2,3,4},{5,-1,-1,2},{4,3,-1,-1}}; //{{2,5,6},{-1,3,2},{4,-1,5}};
        System.out.println("Maximum gold coins : " + MaxGold(lis));
    }


    public static int MaxGold(int[][] seq) {
        int ans = 0;
        for (int i = 0; i < seq.length; i++) {

            boolean flag = false;
            for (int j = 0; j < seq[0].length; j++) {

                if (seq[i][j] == -1) {
                    continue;
                }

                if (i == 0) {
                    flag = true;
                    ans = Math.max(ans, seq[i][j]);
                }else {

                    // -1
                    int a = (i - 1 >= 0) && (j - 1 >= 0) ? seq[i - 1][j - 1] : -1;

                    // 0
                    int b = (i - 1 >= 0) ? seq[i - 1][j] : -1;

                    // +1
                    int c = (j + 1 < seq[i].length) && (i - 1 >= 0) ? seq[i - 1][j + 1] : -1;

                    // all the sorrounding values are -1, so no need to update
                    if (a == -1 && b == -1 && c == -1) {
                        continue;
                    }
                    seq[i][j] = seq[i][j] + Math.max(a, Math.max(b, c));
                    flag = true;
                    ans = Math.max(ans, seq[i][j]);
                }
            }
            if (!flag) {
                return ans;
            }
        }
        return ans;
    }
}
