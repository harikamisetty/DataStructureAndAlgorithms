package com.hari.dsal.Amazon;

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
	
	public static void main(String[] args) {
		int [] jobDifficulty = {6,5,4,3,2,1}; int d = 2;
		
		MinimumDifficultyofaJobSchedule_1335 md = new MinimumDifficultyofaJobSchedule_1335();
		System.out.println(md.minDifficulty(jobDifficulty, d));
	}
}
