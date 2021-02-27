package com.hari.dsal.facebook;

import java.util.Arrays;

public class TriangleTriplets {
	public int solve(int[] nums) {
		if (nums.length < 3)
			return 0;
		int ans = 0;

		Arrays.parallelSort(nums);

		for (int k = nums.length - 1; k > 1; --k) {
			int i = 0, j = k - 1;

			while (i < j) {
				if (nums[i] + nums[j] > nums[k]) {
					ans += j - i;
					--j;
				} else {
					++i;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		TriangleTriplets tt = new TriangleTriplets();
		int[] nums = { 7, 8, 8, 9,100 };
		System.out.println(tt.solve(nums));
	}
}
