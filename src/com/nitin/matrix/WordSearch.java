package com.nitin.matrix;

public class WordSearch {

    public static void main(String[] args) {

        // Word Search
        //char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}; String word = "ABCCED"; // Output : true
        //char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}; String word = "ABCB"; // Output : false
        //char board[][] = {{'a','a'}}; String word = "a"; // Output: true
        char board[][] = {{'C','A','A'},{'A','A','A'},{'B','C','D'}}; String word = "AAB";  // Output: // true
        boolean found = exist(board,word);
        System.out.println("found:" + found);

    }

    public static boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0){
            return false;
        }

        int row = board.length;
        int col = board[0].length;

        if (row*col < word.length()){
            return false;
        }

        for ( int i = 0; i < board.length; i++){
            for ( int j = 0; j < board[i].length; j++){

                // found the first element
                if ( board[i][j] == word.charAt(0)){
                    if (word.length() == 1){
                        return true;
                    }
                    int visited[][] = new int[board.length][board[0].length];
                    if (search(board,i,j,visited,word,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean search(char[][] board, int i, int j, int[][] visited, String word,int wordIndex) {

        if (word.length() == wordIndex){
            return true;
        }

        if ( i < 0 || i >= board.length || j < 0 || j >= board[i].length
                || board[i][j] != word.charAt(wordIndex) || visited[i][j] == 1){
            return false;
        }

        visited[i][j] = 1;

        if (search(board,i-1,j,visited,word,wordIndex + 1) ||
            search(board,i+1,j,visited,word,wordIndex + 1) ||
            search(board,i,j-1,visited,word,wordIndex + 1) ||
            search(board,i,j+1,visited,word,wordIndex + 1)){
            return true;
        }

        visited[i][j] = 0;
        return false;
    }
}
