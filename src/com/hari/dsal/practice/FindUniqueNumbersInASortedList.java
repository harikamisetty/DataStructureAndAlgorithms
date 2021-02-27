package com.hari.dsal.practice;

public class FindUniqueNumbersInASortedList {

	public int solve(int[] nums) {

		int left = 0, count = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			++count;
			left = nextLeft(left, right, nums[left], nums) + 1;
		}
		return count;
	}

	private int nextLeft(int left, int right, int num, int[] nums) {
		while (left < right) {
			int mid = left + ((right - left) >> 1) + 1;
			if (num < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		FindUniqueNumbersInASortedList fun = new FindUniqueNumbersInASortedList();
		int[] nums = { 2, 2, 2, 3, 4, 6, 6 };
		System.out.println(fun.solve(nums));
	}

}
