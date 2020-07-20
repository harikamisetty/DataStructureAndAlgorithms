package com.hari.dsal.matrix;

public class GameofLife {

	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		// If live to dead, mark 2
		// If dead to live, mark 3

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveNeighbors = getNumLiveNeighbors(i, j, board);

				if (board[i][j] == 1) {
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						board[i][j] = 2;
					}
				} else {
					if (liveNeighbors == 3) {
						board[i][j] = 3;
					}
				}
			}
		}

		// Step 2: loop-over the board again and mark 2 as 0 and 3 as 1
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 2) {
					board[i][j] = 0;
				} else if (board[i][j] == 3) {
					board[i][j] = 1;
				}
			}
		}
	}

	private int getNumLiveNeighbors(int row, int col, int[][] board) {
		int result = 0;

		int m = board.length;
		int n = board[0].length;

		// Up
		if (row - 1 >= 0 && (board[row - 1][col] == 1 || board[row - 1][col] == 2)) {
			result += 1;
		}

		// Down
		if (row + 1 < m && (board[row + 1][col] == 1 || board[row + 1][col] == 2)) {
			result += 1;
		}

		// Left
		if (col - 1 >= 0 && (board[row][col - 1] == 1 || board[row][col - 1] == 2)) {
			result += 1;
		}

		// Right
		if (col + 1 < n && (board[row][col + 1] == 1 || board[row][col + 1] == 2)) {
			result += 1;
		}

		// NW
		if (row - 1 >= 0 && col - 1 >= 0 && (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == 2)) {
			result += 1;
		}

		// NE
		if (row - 1 >= 0 && col + 1 < n && (board[row - 1][col + 1] == 1 || board[row - 1][col + 1] == 2)) {
			result += 1;
		}

		// SW
		if (row + 1 < m && col - 1 >= 0 && (board[row + 1][col - 1] == 1 || board[row + 1][col - 1] == 2)) {
			result += 1;
		}

		// SE
		if (row + 1 < m && col + 1 < n && (board[row + 1][col + 1] == 1 || board[row + 1][col + 1] == 2)) {
			result += 1;
		}

		return result;
	}
	
	
	// ******** Best solution
	//mark die -> live , -1
	//mark live -> die , 2
	//updtae() -1 -> 1,2 => 0
	
	final static int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
			{ -1, -1 } };

	private void gameOfLift(int[][] board) {

		if (board == null || board.length == 0)
			return;
		int rows = board.length, cols = board[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 0) {
					int lives = count(board, i, j);
					if (lives == 3) {
						board[i][j] = -1;
					}
				}
				if (board[i][j] == 1) {
					int lives = count(board, i, j);
					if (lives < 2 || lives > 3) {
						board[i][j] = 2;
					}
				}
			}
		}
		updtae(board, rows, cols);
	}

	private void updtae(int[][] board, int rows, int cols) {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (board[i][j] == -1) {
					board[i][j] = 1;
				}
				if (board[i][j] == 2) {
					board[i][j] = 0;
				}
			}
		}
	}

	private int count(int[][] board, int row, int col) {
		int res = 0;

		for (int[] dir : dirs) {
			int newrow = row + dir[0];
			int newcol = col + dir[1];

			if (newrow >= 0 && newrow < board.length && newcol >= 0 && newcol < board[0].length
					&& (board[newrow][newcol] == 1 || board[newrow][newcol] == 2)) {
				res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		int[][] board = {
		                 {0,1,0},
		                 {0,0,1},
		                 {1,1,1},
		                 {0,0,0}
		                 };
		
		GameofLife gol = new GameofLife();
		
		gol.gameOfLift(board);
		
		int rows = board.length;
		int cols = board[0].length;
		
		for (int i = 0; i < rows; i++) {
			System.out.println("\n");
			for (int j = 0; j < cols; j++) {
				System.out.print(board[i][j]);
			}
		}
	}

}













