package com.nitin.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestOfSubstring {

    public static void main(String[] args) {

        //String s = "aabaab!bb"; // Output :3 (ab!)
        //String s = "bbtablud"; //Output : 6 (tablud)
        //String s = "tmmzuxt"; // Output :5 (mzuxt)
        //String s = "abba"; // Output :2 ( ab)
        //String s = "ckilbkd"; // Output :5 ( ilbkd)
        //String s = "pwwkew" ;// Output :3 ( wke )
        String s = "aa"; // Output :2
        //String s = "asjrgapa"; // Output :6 (sjrgap)
        //String s = "dvdf"; // Ouput :3 (vdf)
        //String s = " "; // Output :1
        //String s = "abcabcbb";  // Output :3 ("abc" repeating )
        int l = lengthOfLongestSubstring(s);
        System.out.println("lengthOfLongestSubstring:" + l);

    }


    public static  int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> cc = new HashMap<Character,Integer>();

        int max = 0;

        if (s == ""){
            return 0;
        }

        int currStart = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (cc.containsKey(c)) {
                currStart = Math.max(cc.get(c),currStart);
            }
            max = Math.max(max, i  + 1 - currStart);
            cc.put(c,i + 1);
        }

        return max;
    }

    public static  int lengthOfLongestSubstringNotAccurate(String s) {

        Map<Character,Integer> cc = new HashMap<Character,Integer>();

        int max = 0;

        if (s == ""){
            return 0;
        }

        int curr = 0;

        for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (cc.containsKey(c)) {
                    int found = cc.get(c);
                    if ( i - found < curr) {
                        curr = curr - found;
                    }else if (i - found > curr){
                        curr++;
                    }

                }else{
                    curr++;
                }
                max = Math.max(max, curr);
                cc.put(c,i);
        }

        return max;
    }


    public static  int lengthOfLongestSubstringBrute(String s) {

        Set<Character> cc = new HashSet<Character>();

        int max = 0;

        if (s == ""){
            return 0;
        }


        for (int j = 0; j < s.length(); j++){
            cc = new HashSet<Character>();
            cc.add(s.charAt(j));
            for (int i = j + 1; i < s.length(); i++){
                char c = s.charAt(i);
                if (cc.contains(c)){
                    cc = new HashSet<Character>();
                }
                cc.add(c);
                max = Math.max(max, cc.size());
            }

        }

        return Math.max(max,cc.size());
    }
}
