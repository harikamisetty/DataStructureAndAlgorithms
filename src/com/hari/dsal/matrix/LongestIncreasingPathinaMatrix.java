package com.hari.dsal.matrix;

public class LongestIncreasingPathinaMatrix {

	// DFS

	private int[] dx = new int[] { 0, 0, -1, 1 };
	private int[] dy = new int[] { 1, -1, 0, 0 };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int max = 0;
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, helper(i, j, matrix, dp));
			}
		}
		
		for(int i=0; i<m; i++) {
			System.out.println("\n");
			for(int j=0;j<n;j++) {
				System.out.print(dp[i][j]);
			}
		}

		return max;
	}

	private int helper(int row, int col, int[][] matrix, int[][] dp) {

		if (dp[row][col] > 0) {
			return dp[row][col];
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int curMax = 0;

		for (int i = 0; i < 4; i++) {
			int x = dx[i] + row;
			int y = dy[i] + col;
			
			//Main Logic to buid the path
			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][col]) {
				curMax = Math.max(curMax, helper(x, y, matrix, dp));
			}
		}

		dp[row][col] = curMax + 1;

		return curMax + 1;
	}

	public static void main(String[] args) {

		int grid[][] = { { 1, 2, 3 }, 
						 { 4, 5, 6 }, 
						 { 7, 8, 9 } 
						};

		LongestIncreasingPathinaMatrix bmp = new LongestIncreasingPathinaMatrix();
		System.out.println(bmp.longestIncreasingPath(grid));
	}
}
