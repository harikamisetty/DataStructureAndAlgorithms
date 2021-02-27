package com.hari.dsal.arrays;

public class MaxAndMinSubArray_53 {
	private int maxArraySum(int[] nums) {
		int sum = 0, max = 0;

		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			max = Math.max(max, sum);
		}
		return max;
	}

	private int minArraySum(int[] nums) {
		int sum = 0, min = 0;

		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4  };
		MaxAndMinSubArray_53 maxAMin = new MaxAndMinSubArray_53();
		System.out.println(maxAMin.maxArraySum(nums));
		System.out.println(maxAMin.minArraySum(nums));
	}

}
