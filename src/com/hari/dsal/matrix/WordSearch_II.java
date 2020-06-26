package com.hari.dsal.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch_II {
	
	 /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
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
        p = p.children[c - 'a'];
 
        if (!p.word.isEmpty()) {
            set.add(p.word);
        }
 
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            wordSearchHelper(row + dirs[i][0], col + dirs[i][1], board, visited, set, p);
        }
 
        visited[row][col] = false;
    }

}
