package com.hari.dsal.arrays;

public class MaxSubArray {

	public static void main(String[] args) {
		int A[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaxSubArray maxSubArray = new MaxSubArray();
		System.out.println(maxSubArray.maxsubarray(A));
		System.out.println(maxSubArray.maxsubarray1(A));
		System.out.println(maxSubArray.maxsubarray(A));
	}

	public int maxsubarray(int[] nums) { // Will work for both -ve and +ve values
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

	public int maxSubArray(int[] nums) { // Best solution but won't work if you have all -ve values
		int max = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = sum < 0 ? nums[i] : sum + nums[i];
			max = Math.max(sum, max);
		}
		return max;
	}

	public int maxsubarray1(int[] nums) {
		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				sum = sum + nums[j];
				max = Math.min(sum, max);// Just Change max / min to get values.
			}
		}
		return max;
	}
}
