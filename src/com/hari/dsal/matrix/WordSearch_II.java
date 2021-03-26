package com.hari.dsal.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch_II {

	// WITH TIRE
	public List<String> wordSearchII(char[][] board, List<String> words) {
		List<String> ans = new ArrayList<>();
		if (board == null || board[0] == null || words == null) {
			return ans;
		}

		Set<String> set = new HashSet<>();
		boolean[][] visited = new boolean[board.length][board[0].length];

		// step 1: create a trie and put words into the trie
		//
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		// step 2: scan the board and check if the word in the trie
		//
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				wordSearchHelper(i, j, board, visited, set, trie.root);
			}
		}

		return new ArrayList<>(set);
	}

	private void wordSearchHelper(int row, int col, char[][] board, boolean[][] visited, Set<String> set, TrieNode p) {
		int m = board.length;
		int n = board[0].length;

		if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
			return;
		}

		char c = board[row][col];

		if (p.children[c - 'a'] == null) {
			return;
		}

		visited[row][col] = true;

		// Once found move p further
		p = p.children[c - 'a'];

		if (!p.word.isEmpty()) {
			set.add(p.word);
		}

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int i = 0; i < 4; i++) {
			wordSearchHelper(row + dirs[i][0], col + dirs[i][1], board, visited, set, p);
		}

		visited[row][col] = false;
	}

	// WITHOUT TIRE
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();

		if (board == null || words == null || words.length == 0) {
			return result;
		}

		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];

		for (int w = 0; w < words.length; w++) {
			if (isWordExists(board, words[w], visited, rows, cols)) {
				result.add(words[w]);
			}
		}

		return result;
	}

	private boolean isWordExists(char[][] board, String word, boolean[][] visited, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (existHelper(board, word, 0, i, j, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean existHelper(char[][] board, String word, int start, int row, int col, boolean[][] visited) {
		if (start == word.length()) {
			return true;
		}

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			return false;
		}

		if (visited[row][col]) {
			return false;
		}

		if (board[row][col] != word.charAt(start)) {
			return false;
		}

		visited[row][col] = true;
		boolean result = existHelper(board, word, start + 1, row - 1, col, visited)
				|| existHelper(board, word, start + 1, row + 1, col, visited)
				|| existHelper(board, word, start + 1, row, col - 1, visited)
				|| existHelper(board, word, start + 1, row, col + 1, visited);
		visited[row][col] = false;

		return result;
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };

		WordSearch_II ws = new WordSearch_II();
		List<String> res = ws.findWords(board, words);
		
		for(String str : res) {
			System.out.println(str);
		}
	}
}