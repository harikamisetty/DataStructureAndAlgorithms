package com.hari.dsal.Amazon;

public class DesignAddandSearchWordsDataStructure_211 {

	TrieNode root;

	/** Initialize your data structure here. */
	public DesignAddandSearchWordsDataStructure_211() {
		root = new TrieNode();
	}
	
	// Add a word to Trie

	public void addWord(String word) {
		TrieNode cur = root;
		
		for (char ch : word.toCharArray()) {
			if (cur.children[ch - 'a'] == null)
				cur.children[ch - 'a'] = new TrieNode();
			cur = cur.children[ch - 'a'];
		}
		cur.isWord = true;
	}
	
	// Search a word to trie
	public boolean search(String word) {
		return searchHelper(root, 0, word);
	}

	private boolean searchHelper(TrieNode root, int index, String word) {
		if (index == word.length())
			return root.isWord;

		char ch = word.charAt(index);
		if (ch != '.') {
			if (root.children[ch - 'a'] == null)
				return false;
			return searchHelper(root.children[ch - 'a'], index + 1, word);
		} else {
			for (int i = 0; i < 26; i++)
				if (root.children[i] != null)
					if (searchHelper(root.children[i], index + 1, word))
						return true;
			return false;
		}
	}
}
