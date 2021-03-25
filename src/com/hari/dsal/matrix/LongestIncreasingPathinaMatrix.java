package com.hari.dsal.matrix;

public class LongestIncreasingPathinaMatrix {

	public int longestIncreasingPath_best(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int res = 0;
		int rows = matrix.length, cols = matrix[0].length;
		int[][] dp = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dp[i][j] == 0) {
					dfs_best(matrix, i, j, dp, Integer.MIN_VALUE);
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		return res;

	}

	private int dfs_best(int[][] matrix, int row, int col, int[][] dp, int prev) {
		if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[0].length - 1 || matrix[row][col] <= prev) {
			return 0;
		}

		if (dp[row][col] != 0)
			return dp[row][col];

		int left = dfs_best(matrix, row, col - 1, dp, matrix[row][col]);
		int right = dfs_best(matrix, row, col + 1, dp, matrix[row][col]);
		int up = dfs_best(matrix, row - 1, col, dp, matrix[row][col]);
		int down = dfs_best(matrix, row + 1, col, dp, matrix[row][col]);

		dp[row][col] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
		return dp[row][col];
	}

	public static void main(String[] args) {

		int grid[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		LongestIncreasingPathinaMatrix bmp = new LongestIncreasingPathinaMatrix();
		// System.out.println(bmp.longestIncreasingPath(grid));
		System.out.println(bmp.longestIncreasingPath_best(grid));
	}
}
