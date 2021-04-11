package com.hari.dsal.matrix;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int[] dp = new int[n];
        dp[0] = grid[0][0];
         
        // set the first row
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
         
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
         
        return dp[n - 1];
    }
	
	public static void main(String[] args) {

		int grid[][] = { { 1, 2, 3 }, 
						 { 4, 5, 6 }, 
						 { 7, 8, 9 } 
						};

		MinimumPathSum bmp = new MinimumPathSum();
		System.out.println(bmp.minPathSum(grid));
	}
}
