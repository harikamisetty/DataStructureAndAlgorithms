package com.hari.dsal.Amazon;

import java.util.Arrays;

public class MinimumDifficultyofaJobSchedule_1335 {
	public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        
        
        int[][] dp = new int[d][n];
        
        // Initialize dp for single day
        dp[0][0] = jobDifficulty[0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], jobDifficulty[j]);
        }
        
        // For each day
        for (int i = 1; i < d; i++) {
            
            // For each job
            for (int j = i; j < n; j++) {
                
                // init day max difficulty to current job.
                int dayMax = jobDifficulty[j];
                // init min cost to previous day job j-1 + dayMax
                int minCost = dp[i-1][j-1] + dayMax;
                
                // Travel backwards over the jobs, updating dayMax and recalculating the minCost 
                for (int k = j-1; k >= i; k--) {

                    // update max difficulty if jobs j where k <= j < n
                    dayMax = Math.max(dayMax, jobDifficulty[k]);
                    // update minCost of dayMax plus previous day of jobs j s.t. k < j
                    minCost = Math.min(minCost, dp[i-1][k-1] + dayMax);
                }
                
                // Set minCost of day i for all jobs up to j
                dp[i][j] = minCost;
            }
        }
        // return final minCost of all jobs at last day
        return dp[d-1][n-1];
    }
	
	// Solution #2
	public int minDifficulty_2(int[] jobDifficulty, int d) {
		if(d > jobDifficulty.length)
			return -1;
		int [][] dp = new int[d+1][jobDifficulty.length];
		for(int [] p : dp) {
			Arrays.fill(p, -1);			
		}
		
		return dfs(jobDifficulty, d, dp, 0);
	}
	
	private int dfs(int[] jobDifficulty, int d, int[][] dp, int idx) {
		
		if( d == 1) {
			int max =0;
			while(idx < jobDifficulty.length)
				max = Math.max(max, jobDifficulty[idx++]);
			return max;
		}
		
		if(dp[d][idx] != -1)
			return dp[d][idx];
		int max =0;
		int res = Integer.MAX_VALUE;
		
		for(int i = idx; i < jobDifficulty.length -d +1; i++) {
			max = Math.max(max, jobDifficulty[i]);
			res = Math.min(res, max+dfs(jobDifficulty,d-1,dp,i+1));
		}		
		return dp[d][idx] = res;
	}
	
	// #3 Solution 3
	  public int minDifficulty_3(int[] jobDifficulty, int d) {
		    final int n = jobDifficulty.length;

		    if (n < d)
		      return -1;

		    // dp[i][k] := min difficulty to schedule the first i jobs in k days
		    int[][] dp = new int[n + 1][d + 1];
		    Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE / 2));
		    dp[0][0] = 0;

		    for (int i = 1; i <= n; ++i)
		      for (int k = 1; k <= d; ++k) {
		        int maxDifficulty = 0; // max(job[j + 1..i])
		        for (int j = i - 1; j >= k - 1; --j) { // 1-based
		          maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]); // 0-based
		          dp[i][k] = Math.min(dp[i][k], dp[j][k - 1] + maxDifficulty);
		        }
		      }

		    return dp[n][d];
		  }

	public static void main(String[] args) {
		int [] jobDifficulty = {6,5,4,3,2,1}; int d = 2;
		
		MinimumDifficultyofaJobSchedule_1335 md = new MinimumDifficultyofaJobSchedule_1335();
		System.out.println(md.minDifficulty_3(jobDifficulty, d));
	}
}
