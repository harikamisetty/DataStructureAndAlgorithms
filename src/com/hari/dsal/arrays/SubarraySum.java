package com.hari.dsal.arrays;

public class SubarraySum {
	public static void main(String[] args) {
		SubarraySum ss = new SubarraySum();
		int[] nums = { 1, 2, 1, 2, 1 };
		System.out.println(ss.subarraySum(nums, 3));
	}

	public int subarraySum(int[] nums, int k) {

		int len = nums.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			int windowsum = 0;
			for (int j = i; j < len; j++) {
				windowsum = windowsum + nums[j];
				if (windowsum == k)
					count++;
			}
		}
		return count;
	}
}
