package com.nitin.string;

import java.util.HashSet;
import java.util.Set;

public class longestOfSubstring {

    public static void main(String[] args) {

        //String s = "as"; // Output : 2
        String s = "asjrgapa"; // Output : 6 (sjrgap)
        //String s = "dvdf"; // Ouput : 3 (vdf)
        //String s = " "; // Output : 1
        //String s = "abcabcbb";  // Output : 3 ("abc" repeating )
        int l = lengthOfLongestSubstring(s);
        System.out.println("lengthOfLongestSubstring:" + l);

    }

    public static  int lengthOfLongestSubstring(String s) {

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
