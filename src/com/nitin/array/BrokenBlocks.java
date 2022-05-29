package com.nitin.array;

public class BrokenBlocks {


    public static void main(String[] args) {

        int lis[][] =  {{10,20,3,40}, {1,2,-1,-1}}; // Output: 40
        //{{3,2,-1}, {4,-1,-1}, {-1, -1,7},{2,3,8}};// {{-1,2,3,4},{5,-1,-1,2},{4,3,-1,-1}}; //{{2,5,6},{-1,3,2},{4,-1,5}};
        System.out.println("Maximum gold coins : " + maxGold(lis)); //
    }


    public static int maxGold(int[][] seq) {
        int ans = 0;
        for (int i = 0; i < seq.length; i++) {
            System.out.println("iii:" + i);
            System.out.println("ans iii:" + ans);
            boolean flag = false;
            for (int j = 0; j < seq[0].length; j++) {
                System.out.println("j:" + j);
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
                    System.out.println("Math.max(a, Math.max(b, c)" + Math.max(a, Math.max(b, c)));
                    System.out.println("seq[i][j]" + seq[i][j]);
                    System.out.println("ans:" + ans);
                    ans = Math.max(ans, seq[i][j]);
                    System.out.println("Math.max(ans, seq[i][j])" + Math.max(ans, seq[i][j]));
                    flag = true;
                }
            }
            if (!flag) {
                return ans;
            }
        }
        return ans;
    }
}
