package com.nitin.string;

public class ValidPalindrome2 {

    public static void main(String[] args) {

        /*Write a function that takes a string as input and checks
        whether it can be a valid palindrome by removing at most one character from it.
        */
        String s = "tebbem";
        boolean l = isPalindrome(s);
        System.out.println("Palindrome2: " + l);
    }
    public static boolean isPalindrome(String s) {
        // Write your code here
        // Tip: You may use the code template provided
        // in the TwoPointers.java file

        if (s.length() == 0){
            return false;
        }

        for (int i = 0 ; i < s.length() ; i++){
            if (checkForPalindrome(s,i)){
                return true;
            }
        }

        return false;
    }

    public static boolean checkForPalindrome(String s,int i){

        int start = 0;
        int end = s.length() - 1;

        while (start < end){
            if (start == i){
                start++;
            }else if (end == i){
                end--;
            }

            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;

    }
}
