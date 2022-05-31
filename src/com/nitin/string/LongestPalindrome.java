package com.nitin.string;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "cbbd";// output :bb
        //String s = "babad"; // output :
        //String s = "ab"; // output "b" or "a"
        //String s = "acbabvghgv"; // output : "bab"
        //int len1 = expandFromMiddle(s,3,3);
        String output = longestPalindrome(s);
        System.out.println("longestPalindrome: " + output);
   }

    public static String longestPalindrome(String s) {

        if (s.length() == 0 || s == null){ return "";}

        if (s.length() == 1){ return s; }

        int start = 0;
        int end = 0;

        for ( int i = 0; i < s.length(); i++){

            int len1 = expandFromMiddle(s,i,i);
            int len2 = expandFromMiddle(s,i,i+1);
            int len = Math.max(len1,len2);

            if (end - start < len){
                start  = i - (len-1)/2;
                end = i + (len/2);
            }
        }

        return s.substring(start,end + 1);

    }


    public static int expandFromMiddle(String s, int left, int right){


        while ( left >=0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
            left = left - 1;
            right = right + 1;
        }

        return right - left -1;
    }



    public static String longestPalindromeBrute(String s) {

        if (s.length() == 0 || s == null){ return "";}

        if (s.length() == 1){ return s; }

        int maxLength = 1;
        int start = 0;
        int end = 1;

        for (int i = 0; i < s.length() - 1 ; i++){
            for ( int j = i + 1; j < s.length(); j++){
                String sub = s.substring(i,j + 1);

                if ( isPalindrome(s.substring(i,j+1))){
                    if (maxLength < j - i + 1){
                        maxLength = j - i + 1;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }
        System.out.println("start:" + start);
        System.out.println("end:" + end);

        return s.substring(start,end);
    }

    private static boolean isPalindrome(String substring) {
        int start = 0;
        int end = substring.length() - 1;

        while (start < end){
            if (substring.charAt(start) != substring.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
