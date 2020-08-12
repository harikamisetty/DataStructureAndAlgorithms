package com.hari.dsal.matrix;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(board);
	}

	private boolean isValid(int row, int col, char target, char[][] board) {
		// check the row and column
		for (int i = 0; i < 9; i++) {
			if ((board[row][i] == target) || (board[i][col] == target)) {
				return false;
			}
		}

		// check the block
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int x = row / 3 * 3 + i; // nth block * block_size + offset
				int y = col / 3 * 3 + j;
				if (board[x][y] == target) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean solveHelper(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; k++) {
						if (isValid(i, j, k, board)) {
							board[i][j] = k;
							if (solveHelper(board) == true) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return;
		}

		solveHelper(board);
	}

}
