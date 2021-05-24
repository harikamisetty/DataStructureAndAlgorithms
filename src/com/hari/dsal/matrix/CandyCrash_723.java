package com.hari.dsal.matrix;

public class CandyCrash_723 {

	public int[][] candyCrush(int[][] board) {
		int m = board.length;
		int n = board[0].length;

		boolean haveCrushes = true;
		// TO VALIDATE ALL CREASHES
		while (haveCrushes) {
			haveCrushes = false;

			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++) {
					int val = Math.abs(board[i][j]);
					if (val == 0)
						continue;

					// Crush vertical candies
					if (j + 2 < n && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
						haveCrushes = true;
						for (int k = j; k < j + 3; k++) {
							board[i][k] = -val;
						}
					}

					// Crash Horizontal
					if (i + 2 < m && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
						haveCrushes = true;
						for (int k = i; k < i + 3; k++)
							board[k][j] = -val;
					}
				}

			if (haveCrushes) {
				for (int j = 0; j < n; j++) {
					int nextIndex = m - 1;
					for (int i = m - 1; i >= 0; i--)
						if (board[i][j] > 0) {
							board[nextIndex--][j] = board[i][j];
						}
					for (int i = nextIndex; i >= 0; i--)
						board[i][j] = 0;
				}
			}
		}
		return board;
	}

	public static void main(String[] args) {
		CandyCrash_723 cc = new CandyCrash_723();
		int[][] input = { { 110, 5, 112, 113, 114 }, { 210, 211, 5, 213, 214 }, { 310, 311, 3, 313, 314 },
				{ 410, 411, 412, 5, 414 }, { 5, 1, 512, 3, 3 }, { 610, 4, 1, 613, 614 }, { 710, 1, 2, 713, 714 },
				{ 810, 1, 2, 1, 1 }, { 1, 1, 2, 2, 2 }, { 4, 1, 4, 4, 1014 } };
		int[][] res = cc.candyCrush(input);
		
		for(int i=0;i<res.length;i++) {
			System.out.println("\n");
			for(int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]+",");
			}
		}
	}

}
