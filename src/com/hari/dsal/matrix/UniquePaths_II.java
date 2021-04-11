package com.hari.dsal.matrix;

public class UniquePaths_II {

	// When there is a obstrucle "1" should not consider the Path
	private int uniquepaths(int[][] grid) {
		int m = grid.length;
		int width = grid[0].length;

		if (grid[0][0] == 1 || grid[m - 1][width - 1] == 1)
			return 0;

		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : grid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1) {
					dp[j] = 0; // Make the path as Zero
				} else if (j > 0) {
					dp[j] = dp[j] + dp[j - 1]; // LOGIC only based on No Of Columns
				}
			}
		}
		return dp[width - 1];
	}

	public int uniquePathsWithObstacles_DP(int[][] obstacleGrid) {
		final int m = obstacleGrid.length;
		final int n = obstacleGrid[0].length;

		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (obstacleGrid[i][j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];

		return dp[n - 1];
	}

	public static void main(String[] args) {

		int gridInt[][] = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		UniquePaths_II up = new UniquePaths_II();
		System.out.println(up.uniquepaths(gridInt));
	}

}
