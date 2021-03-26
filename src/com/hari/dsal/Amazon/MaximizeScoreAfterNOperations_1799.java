package com.hari.dsal.Amazon;

public class MaximizeScoreAfterNOperations_1799 {
	int[][] dp;

	public int maxScore(int[] nums) {
		int len = nums.length;
		dp = new int[len / 2][1 << len];
		return helper(0, 0, nums);
	}

	public int helper(int cnt, int mask, int[] nums) {
		int len = nums.length;
		
		if (cnt == len / 2)
			return 0;
		
		if (dp[cnt][mask] != 0)
			return dp[cnt][mask];
		
		int res = 0;
		for (int i = 0; i < len - 1; i++) {
			int next = mask | (1 << i);
		
			if (mask == next)
				continue;
			
			for (int j = i + 1; j < len; j++) {
				int orig = next;
				next |= (1 << j);
			
				if (next == orig)
					continue;
				
				int local = (cnt + 1) * gcd(nums[i], nums[j]);
				res = Math.max(res, local + helper(cnt + 1, next, nums));
				next = orig;
			}
		}
		return dp[cnt][mask] = res;
	}

	public int gcd(int i, int j) {
		if (i == 0)
			return j;
		return gcd(j % i, i);
	}

	public static void main(String[] args) {
		MaximizeScoreAfterNOperations_1799 ms = new MaximizeScoreAfterNOperations_1799();
		int[] nums = { 3, 4, 6, 8 };
		System.out.println(ms.maxScore(nums));
	}
}
