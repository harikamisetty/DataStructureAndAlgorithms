package com.hari.dsal.arrays;

public class MinimumSizeSubArraySum {

	public int minSubArrayLen(int s, int a[]) {

		if (a == null || a.length == 0)
			return 0;

		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

		while (j < a.length) {
			sum = sum + a[j++];

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum = sum - a[i++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	public static void main(String[] args) {
		int A[] = {2,3,1,2,4,3};
		MinimumSizeSubArraySum minSubArray = new MinimumSizeSubArraySum();
		
		System.out.println(minSubArray.minSubArrayLen(7, A));
		
	}
}
