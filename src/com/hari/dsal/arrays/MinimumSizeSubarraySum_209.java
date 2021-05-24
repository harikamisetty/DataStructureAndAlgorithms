package com.hari.dsal.arrays;

public class MinimumSizeSubarraySum_209 {
	
	public int minSubArrayLen(int target, int[] nums) {
		int ans = Integer.MAX_VALUE;
		int sum = 0, l = 0;

		for (int r = 0; r < nums.length; r++) {
			sum = sum + nums[r];

			while (sum >= target) {
				ans = Math.min(ans, r - l + 1);
				sum = sum - nums[l++];
			}
		}
		return ans != Integer.MAX_VALUE ? ans : 0;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum_209 msb = new MinimumSizeSubarraySum_209();
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(msb.minSubArrayLen(7, nums)); // 4,3
	}
}
