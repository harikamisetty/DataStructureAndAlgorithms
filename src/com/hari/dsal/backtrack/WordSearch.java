package com.hari.dsal.backtrack;

public class WordSearch {

	private boolean exist(char[][] board, String word) {

		char [] w = word.toCharArray();
		int m = board.length;
		int n = board[0].length;

		for(int y =0; y< m; y++) {
			for(int x =0;x< n; x++) {
				if(exist(board,y,x,w,0))
					return true;
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int x, int y, char[] word, int i) {
		// Found word
		if(i == word.length) {
			return true;
		}

		// ROW and COLUMN limit exceeds
		if(y<0 || x<0 || x==board.length || y==board[x].length)
			return false;

		// Negative Condition found
		if(board[x][y] != word[i])
			return false;

		// Partially Found so continue
		boolean exist =    exist(board, x, y+1, word, i+1)
						|| exist(board, x, y-1, word, i+1)
						|| exist(board, x-1, y, word, i+1)
						|| exist(board, x+1, y, word, i+1);

		// Update the character once it's found to avoid loops.
		board[x][y] ='#';

		return exist;
	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] input = {{'a','b','s'},
						  {'p','u','e'},
						  {'p','s','e'}};
		System.out.println(ws.exist(input,"see"));
		System.out.println(ws.exist(input,"eee"));
	}
}
