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

	private boolean exist(char[][] board, int y, int x, char[] word, int i) {
		// Found word
		if(i == word.length) {
			return true;
		}

		// ROW and COLUMN limit exceeds
		if(y<0 || x<0 || y==board.length || x==board[y].length)
			return false;

		// Negative Condition found
		if(board[y][x] != word[i])
			return false;

		// Partially Found so continue
		boolean exist =    exist(board, y, x+1, word, i+1)
						|| exist(board, y, x-1, word, i+1)
						|| exist(board, y-1, x, word, i+1)
						|| exist(board, y+1, x, word, i+1);

		// Update the character once it's found to avoid loops.
		board[y][x] ^=256;

		return exist;
	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] input = {{'a','b','s'},
						  {'p','u','e'},
						  {'p','s','e'}};
		System.out.println(ws.exist(input,"see"));
		System.out.println(ws.exist(input,"eee"));
		char t = 'e'^256;
		System.out.println(t);
	}

}
