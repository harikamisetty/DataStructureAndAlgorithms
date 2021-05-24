package com.hari.dsal.arrays;

public class MaximumProductOfThreeNumbers_628 {

	private int maxProfit(int[] nums) {

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int min1 = 0;
		int min2 = 0;

		for (int num : nums) {

			if (num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;

			} else if (num > max2) {
				max3 = max2;
				max2 = num;
			} else if(num > max3){
				max3 = num;
			}

			if (num < min1) {
				min2 = min1;
				min1 = num;
			} else if(num< min2){
				min2 = num;
			}
		}
		return Math.max(min1 * min2 * max1, max1 * max2 * max3);
	}
	
	public static void main(String[] args) {
		MaximumProductOfThreeNumbers_628 mpt = new MaximumProductOfThreeNumbers_628();
		int [] nums = {20,4,6,9,10,12,15};
		System.out.println(mpt.maxProfit(nums));
	}
}
