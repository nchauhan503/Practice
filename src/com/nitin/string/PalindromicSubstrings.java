package com.nitin.string;

public class PalindromicSubstrings {



    public static void main(String[] args) {

        String s = "aba";  // Output :3  | Three palindromic strings: "a", "b", "c".
        //String s = "aaa"; // Output :6 | Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
        int l = countSubstringsExpand(s);
        System.out.println("Palindromic Strings count: " + l);

    }


    public static int countSubstringsExpand(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }

        if (s.length() == 1){
            return 1;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++){

            int count1 = expandFromMiddle(s,i,i);
            int count2 = expandFromMiddle(s,i,i+1);
            count  +=  count1 + count2;
        }

        return count;
    }

    public static int expandFromMiddle(String s, int left, int right){
        int count = 0;
        while (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            System.out.println("Possible palindrome: " + s.substring(left, right + 1));
            count++;
            left--;
            right++;
        }

        return count;

    }

    public static int countSubstringsBrute(String s) {

        if (s.length() == 0 || s == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length() ; j++){

                if (isPalindrome(s.substring(i,j+1))){
                    count++;
                }
            }
        }

        return count;
    }


    private static boolean isPalindrome(String substring) {

        if (substring.length() == 1){
            return true;
        }

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


