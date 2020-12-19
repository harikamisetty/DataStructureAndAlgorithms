package com.hari.dsal.Amazon;

public class SlidingWindowMaximum_239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		
		int n = nums.length;
	    if (n * k == 0) return new int[0];
		int res[] = new int[n - k+1];
		int p = 0;

		for (int i = 0; i < nums.length - k+1; i++) {
			int max = 0;
			for (int j = i; j < i + k; j++) {
				max = Math.max(nums[j], max);
			}
			res[p++] = max;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		SlidingWindowMaximum_239 swm = new SlidingWindowMaximum_239();
		for (int val : swm.maxSlidingWindow(a, k)) {
			System.out.print(val + ",");
		}
	}
}
