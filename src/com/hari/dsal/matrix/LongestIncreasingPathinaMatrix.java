package com.hari.dsal.matrix;

public class LongestIncreasingPathinaMatrix {
	
	
	// */************** BEST Solution - DFS
	public int longestIncreasingPath1(int[][] matrix) {
		if(matrix ==null || matrix.length ==0)
			return 0;
		int res =0;
		int rows= matrix.length, cols = matrix[0].length;
		int [][] dp = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(dp[i][j] ==0) {					
					dfs(matrix,i,j,dp,Integer.MIN_VALUE);
					res = Math.max(res, dp[i][j]);
				}				
			}
		}		
		return res;
	}
	
	
	private int dfs(int[][] matrix, int row, int col, int[][] dp, int prev) {
		if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[0].length-1 || matrix[row][col] <= prev) {
			return 0;
		}

		if (dp[row][col] != 0)
			return dp[row][col];

		int left = dfs(matrix, row, col - 1, dp, matrix[row][col]);
		int right = dfs(matrix, row, col + 1, dp, matrix[row][col]);
		int up = dfs(matrix, row - 1, col, dp, matrix[row][col]);
		int down = dfs(matrix, row + 1, col, dp, matrix[row][col]);
		
		dp[row][col] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
		return dp[row][col];
	}
	
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
		System.out.println(bmp.longestIncreasingPath1(grid));
	}
}
