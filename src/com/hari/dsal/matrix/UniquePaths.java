package com.hari.dsal.matrix;

import java.util.Collections;

public class UniquePaths {

	// Recursive
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] dp = new int[m + 1][n + 1];
		return uniquePathsHelper(m, n, dp);
	}

	private int uniquePathsHelper(int m, int n, int[][] dp) {
		if (m == 1 || n == 1) {
			return 1;
		}

		if (dp[m][n] != 0) {
			return dp[m][n];
		}

		dp[m][n] = uniquePathsHelper(m - 1, n, dp) + uniquePathsHelper(m, n - 1, dp);
		return dp[m][n];
	}

	// DP Programming --------- Best solution

	public int uniquePaths2(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		Collections.sort(null);

		int[][] dp = new int[m][n];

		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

	public int uniquePaths3(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}
		return dp[n - 1];
	}

	// DP with Space optimization

	public int uniquePaths4(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] dp = new int[m + 1][n + 1];
		return uniquePathsHelper4(m, n, dp);
	}

	private int uniquePathsHelper4(int m, int n, int[][] dp) {
		if (m == 1 || n == 1) {
			return 1;
		}

		if (dp[m][n] != 0) {
			return dp[m][n];
		}

		dp[m][n] = uniquePathsHelper(m - 1, n, dp) + uniquePathsHelper(m, n - 1, dp);
		return dp[m][n];
	}
	
	// O(n) Solution
	private int uniquePathSum_dp1(int m, int n) {
		// Total No of paths
		int N = n + m -2;
		// Paths tp down
		int k = m - 1;
		double res = 1;
		// Combinationa (N,K) = N! / (K!(N - K)!)
		// C= ((n-k+1) * (n-k+2)..........*n)
		for(int i = 1; i <= k; i++) {
			res = res * (N-k+i) / i;
		}
		return (int)res;
	}
	
	public static void main(String[] args) {
		
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePathSum_dp1(3, 3));
	}

}
