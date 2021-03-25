package com.hari.dsal.dp;

public class MaximumProductSubarray_152 {
	public int maxProduct(int[] nums) {
		int ans = nums[0];
		int dpmin = nums[0];
		int dpmax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			int premin = dpmin;
			int premax = dpmax;

			if (num < 0) {
				dpmin = Math.min(premax * num, num);//-12
				dpmax = Math.max(premin * num, num);//-2
			} else {
				dpmin = Math.min(premin * num, num);//2,3,-48
				dpmax = Math.max(premax * num, num);//2,6,4
			}
			ans = Math.max(ans, dpmax);
		}
		return ans;

	}

	public static void main(String[] args) {
		MaximumProductSubarray_152 mps = new MaximumProductSubarray_152();
		int[] nums = { 2, 3, -2, 8 };
		System.out.println(mps.maxProduct(nums));
	}
}
