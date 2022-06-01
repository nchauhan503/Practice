package com.nitin.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


    public static void main(String[] args) {

        //String s = "ADOBECODEBANC"; String t = "ABC"; // Output: "BANC"
        //String s = "a"; String t = "aa"; // Output: ""
        //String s = "a"; String t = "a"; // Output : "a"
        //String s = "a"; String t = "b"; // Output : ""
        String s = "aa"; String t = "aa"; // Output : "aa"
        String output = minWindow(s,t);
        System.out.println("MinWindow substring: " + output);
    }

    public static String minWindow(String s, String t) {

        if (s.length() < t.length() || t.length() == 0 || s.length() == 0){
            return "";
        }

        Map<Character,Integer> c = new HashMap<>();
        createMap(t,c);

        int start = -1;
        int end = -1;
        int left = 0;
        int right = t.length() - 1;

        if (left == right && s.contains(t) ){
            return t;
        }

        Map<Character,Integer> tracker = new HashMap<>();
        createMap(s.substring(left,right + 1),tracker);

        int currMinSubstring = s.length();

        while (left <= right && right <= s.length()-1){

            //get the substring from s, and check if it contains all the elements in t
            String sub = s.substring(left,right+1);
            if (isValidSubstring(sub,tracker,c)){

                if (currMinSubstring >= right - left + 1 ){
                    currMinSubstring = right - left + 1;
                    start = left;
                    end = right;
                }
                if (tracker.containsKey(s.charAt(left))){
                    Integer curr = tracker.get(s.charAt(left));
                    if ( curr > 1){
                        curr--;
                        tracker.put(s.charAt(left),curr);
                    }else{
                        tracker.remove(s.charAt(left));
                    }
                }
                left++;
            }else{
                right++;
                if (right >= s.length()){
                    break;
                }
                if (tracker.containsKey(s.charAt(right))){
                    Integer curr = tracker.get(s.charAt(right));
                    curr++;
                    tracker.put(s.charAt(right),curr);
                }else{
                    tracker.put(s.charAt(right),1);
                }
            }
        }

        if (start >= 0 && end>= 0) {
            return s.substring(start, end + 1);
        }else{
            return "";
        }
    }

    private static boolean isValidSubstring (String sub, Map<Character,Integer> tracker, Map<Character,Integer> c) {
        for (Map.Entry<Character,Integer> check : c.entrySet()){
            if (!tracker.containsKey(check.getKey())){
                return false;
            }

            if (tracker.get(check.getKey()) < check.getValue()){
                return false;
            }
        }
        return true;
    }


    private static void createMap(String t, Map<Character, Integer> c) {

        for (int i = 0; i < t.length(); i++){
            if (c.containsKey(t.charAt(i))){
                Integer curr = c.get(t.charAt(i));
                curr++;
                    c.put(t.charAt(i),curr);
            }else{
                c.put(t.charAt(i),1);
            }
        }
    }
}
