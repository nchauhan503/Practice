package com.nitin.tree;

public class Trie {

    class TrieNode {

        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++){
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();

    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length(); i++){
            if (!node.containsKey(word.charAt(i))){
                return  false;
            }
            node = node.get(word.charAt(i));
        }

        if ( node.isEnd()){
            return true;
        }
        return false;

    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0 ; i < prefix.length(); i++){
            if (!node.containsKey(prefix.charAt(i))){
                return  false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}
