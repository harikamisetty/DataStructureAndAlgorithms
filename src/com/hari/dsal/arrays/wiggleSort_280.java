package com.hari.dsal.arrays;

public class wiggleSort_280 {
	public void wiggleSort(int[] nums) {
		// 1. if i is even, then nums[i] <= nums[i - 1]
		// 2. if i is odd, then nums[i] >= nums[i - 1]
		for (int i = 1; i < nums.length; ++i)
			if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1]))
				swap(nums, i, i - 1);
	}

	private void swap(int[] nums, int i, int j) {
		final int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		wiggleSort_280 w280 = new wiggleSort_280();
		int[] nums = { 3, 5, 2, 1, 6, 4 };
		w280.wiggleSort(nums);

		for (int val : nums) {
			System.out.print(val + " ");
		}
	}
}
