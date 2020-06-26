package com.hari.dsal.matrix;

public class TrieNode {
	
	 TrieNode[] children;
	    String word;
	 
	    public TrieNode() {
	        children = new TrieNode[26];
	        word = "";
	    }

}
