package com.nitin;

import java.util.*;

public class PathExists {

    public static void main(String[] args) {
        // write your code here
        int edges[][] ={{0,1},{0,2},{3,5},{5,4},{4,3}};  // {{0,1},{0,2},{3,5},{5,4},{4,3}}   {{0,1},{1,2},{2,0},{3,2}}
        boolean isValid =  validPath(6,edges,0,5);
        System.out.println("isValid:" + isValid);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {


        Map<Integer, Set<Integer>> adjacencyList = createAdjacencyList(edges);
        Set<Integer> visited = new HashSet<Integer>();

        System.out.println("adjacencyList:" + adjacencyList);

        boolean result = explore(adjacencyList,source,destination,visited);
        return result;
    }

    private static boolean explore(Map<Integer, Set<Integer>> adjacencyList, int source, int destination, Set<Integer> visited) {

        if ( source == destination){
            return true;
        }

        visited.add(source);

        System.out.println("source" + source);
        System.out.println("adjacencyList.get(source):" + adjacencyList.get(source));

        for (int i : adjacencyList.get(source)){

            if (!visited.contains(i)){
                if (explore(adjacencyList,i,destination,visited) == true ){
                    return true;
                }
            }
        }

        return false;
    }


    //Code to createAdjacencyList
    private static Map<Integer, Set<Integer>> createAdjacencyList (int[][] edges){

        Map<Integer, Set<Integer>> adjacencyList = new HashMap<Integer,Set<Integer>>();

        for (int i = 0; i < edges.length ;i++){

            int a = edges[i][0];
            int b = edges[i][1];


            if (!adjacencyList.containsKey(a)){
                Set<Integer> val = new HashSet<Integer>();
                val.add(b);
                adjacencyList.put(a,val);
            }else{
                adjacencyList.get(a).add(b);
            }

            if (!adjacencyList.containsKey(b)){
                Set<Integer> val = new HashSet<Integer>();
                val.add(a);
                adjacencyList.put(b,val);
            }else{
                adjacencyList.get(b).add(a);
            }
        }
        return adjacencyList;

    }
}
