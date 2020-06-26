package com.hari.dsal.matrix;

public class Trie {
	TrieNode root;
	 
    public Trie() {
        root = new TrieNode();
    }
 
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
 
            p = p.children[c - 'a'];
        }
 
        p.word = word;
    }

}
