package com.nitin.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longestRepeatingCharReplaced {


    /*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
    You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.
    */

    public static void main(String[] args) {

        String s = "ABAB"; int k = 2; // Output: 4 (AAAA or BBBB)
        //String s = "AABABBA"; int k = 1; // Output: 4 ( AAAABBA or AABBBBA )
        int l = characterReplacement(s,k);
        System.out.println("lengthOfLongestSubstring: " + l);


        /*
        Possible way:
        1. Create a Map<char,List<Integer>>
        2. Iterate the string and populate it.
        3. Iterate over the Map and use K to find the max count
         */

    }

    public static int characterReplacement(String s, int k) {

        int maxLength = 0;

        int maxFreq = 0;
        // array to keep track of each letter's count, this count will help in calculating the maxFrep parameter
        int count[] = new int[26];

        // sliding window start
        int start = 0;

        // for loop, end is sliding window end
        for (int end = 0; end < s.length() ; end++){
            //int c = ++count[s.charAt(end) - 'A'];

            // maxFreq keeps track of the most common occoured element in the string
            maxFreq = Math.max(maxFreq,++count[s.charAt(end) - 'A']);

            // start decreasing the window only when the replacing letters count (end - start + 1 - maxFreq) is more than what we can actually replace it with (k)
            while ( end - start + 1 - maxFreq > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }

            // keep on updating the maxLength
            maxLength = Math.max(maxLength,end - start + 1);
        }



        return maxLength;
    }

    public static int characterReplacement3(String s, int k) {

        int max = 0;

        Map<Character, List<Integer>> cc = new HashMap<Character, List<Integer>>();


        for ( int i = 0; i < s.length(); i++){
            if (cc.containsKey(s.charAt(i))){
                cc.get(s.charAt(i)).add(i);
            } else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                cc.put(s.charAt(i),l);
            }

        }

        for ( Map.Entry<Character, List<Integer>> entry : cc.entrySet() ) {

            System.out.println("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
            System.out.println();
        }

        for ( Map.Entry<Character, List<Integer>> entry : cc.entrySet() ){

            List<Integer> curr = entry.getValue();

            int maxLen = 0;


            for (int i = 0 ; i < curr.size() - 2; i++){
                int maxChanges = k;
                for (int j = i + 1 ; j < curr.size() - 1; j++){

                    if (maxChanges == 0){
                        break;
                    }

                    if (curr.get(j) - curr.get(i) <= maxChanges) {
                        i++;
                        maxChanges--;
                        maxLen = Math.max(curr.get(j) - curr.get(i) + 1,maxLen);
                    }


                }
            }

            max = Math.max(max,maxLen);
        }

        return max;
    }
}
