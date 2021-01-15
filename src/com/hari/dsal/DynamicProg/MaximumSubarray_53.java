package com.hari.dsal.DynamicProg;

/*
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
	Output: 6
	Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray_53 {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int n = nums.length;

		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			int prevNum = dp[i - 1] > 0 ? dp[i - 1] : 0;
			dp[i] = nums[i] + prevNum;
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSubarray_53 ms = new MaximumSubarray_53();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(ms.maxSubArray(nums));
	}
}
