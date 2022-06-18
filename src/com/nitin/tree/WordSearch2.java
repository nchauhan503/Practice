package com.nitin.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2 {

    static class Trie{
        boolean isEnd = false;
        Map<Character, Trie> tries = new HashMap();

        void insert(String word){
            Trie t = this;
            for (int i = 0 ; i < word.length(); i++){

                if (!t.tries.containsKey(word.charAt(i))){
                    t.tries.put(word.charAt(i),new Trie());
                }
                t = t.tries.get(word.charAt(i));
            }
            t.isEnd = true;
        }
    }

    public static void main(String[] args) {

        Trie root = new Trie();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"hklf","hf"};
        //String[] words = {"oath","pea","eat","rain"};

        //char[][] board = {{'a'}};
        //String[] words = {"a"};

        //char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        //String[] words = {"oa","oaa"};

        // Output : ["eat","oath"]
        List<String> lis = findWords(board,words,root);

        for ( String l : lis) {
            System.out.println("resunt:" + l);
        }

    }


    public static List<String> findWords(char[][] board, String[] words, Trie root) {

        //put all the words in trie
        addWord(words,root);
        List<String> res = new ArrayList<>();

        // iterate over the array and run dfs each time we encounter a letter
        for ( int i = 0; i < board.length; i++){
            for ( int j = 0; j < board[i].length; j++){
                System.out.println("i:" + i + " j:" + j + " value:" + board[i][j]);
                if (root.tries.containsKey( board[i][j])){
                    System.out.println("found");
                    StringBuilder sb = new StringBuilder();
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    dfs(board,i,j,root,sb,visited,res);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] board, int i, int j, Trie node, StringBuilder sb,boolean[][] visited,List<String> res) {

        // check for bounds and visited
        if (i <= board.length - 1 && i >= 0 && j <= board[i].length - 1 && j >= 0
                && node.tries.containsKey(board[i][j]) &&  !visited[i][j] ){

            node = node.tries.get(board[i][j]);
            visited[i][j] = true;
            sb.append(board[i][j]);
            if (node.isEnd){
                node.isEnd = false;
                res.add(sb.toString());
            }
            dfs(board,i+1,j,node,sb,visited,res);
            dfs(board,i-1,j,node,sb,visited,res);
            dfs(board,i,j+1,node,sb,visited,res);
            dfs(board,i,j-1,node,sb,visited,res);
            sb.deleteCharAt(sb.length() - 1);
            visited[i][j] = false;
        }
    }


    private static void addWord(String[] words,Trie root) {
        for (String s : words){
            root.insert(s);
        }
    }
}
