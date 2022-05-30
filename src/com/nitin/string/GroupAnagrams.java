package com.nitin.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> l = groupAnagrams(strs);
        System.out.println("groupAnagrams:" + l);

    }


    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>() ;

        Map<String,List<String>> sortedMap = new HashMap<String, List<String>>();


        for (String curr : strs){
            createMap(curr,sortedMap);
        }

        for ( Map.Entry<String,List<String>> l : sortedMap.entrySet() ){

            result.add(l.getValue());

        }

        return result;
    }

    private static Map<String, List<String>> createMap(String curr,Map<String, List<String>> sortedMap) {


        char toChar[] = curr.toCharArray();

        Arrays.sort(toChar);

        String output = new String(toChar);

        if ( sortedMap.containsKey(output) ){
            sortedMap.get(output).add(curr);
        }else{
            List<String> anagramList = new ArrayList<String>();
            anagramList.add(curr);
            sortedMap.put(output,anagramList);
        }

        return sortedMap;

    }

}
